package traore.adama.nextcut_android.viewmodel

import android.app.Activity
import android.app.Application
import android.content.Intent
import android.util.Log
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.api.ApiException
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.GoogleAuthProvider
import traore.adama.nextcut_android.utils.Constants
import traore.adama.nextcut_android.R
import traore.adama.nextcut_android.utils.extensions.shortToast

class LoginViewModel(application: Application) : BaseViewModelContext(application) {

    lateinit var auth: FirebaseAuth
    val Tag: String = LoginViewModel::class.java.simpleName;
    val gso: GoogleSignInOptions
    val googleSignInClient: GoogleSignInClient

    init {
        auth = FirebaseAuth.getInstance()
        gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestIdToken(application.getString(R.string.default_client_id))
            .build()

        googleSignInClient = GoogleSignIn.getClient(application, gso)
    }



    fun activityForResultLogin(requestCode:Int, resultCode: Int, data: Intent?, activity: Activity){
        if(requestCode == Constants.RC_SIGN_IN){
            val task = GoogleSignIn.getSignedInAccountFromIntent(data)
            try {
                // Google Sign In was successful, authenticate with Firebase
                val account = task.getResult(ApiException::class.java)
                firebaseAuthWithGoogle(account!!, activity)
            } catch (e: ApiException) {
                // Google Sign In failed, update UI appropriately
                Log.w(Tag, "Google sign in failed", e)
                // ...
            }
        }
    }

    private fun firebaseAuthWithGoogle(acct: GoogleSignInAccount, activity: Activity) {
        Log.d(Tag, "firebaseAuthWithGoogle:" + acct.id!!)

        val credential = GoogleAuthProvider.getCredential(acct.idToken, null)
        auth.signInWithCredential(credential)
            .addOnCompleteListener(activity) { task ->
                if (task.isSuccessful) {
                    // Sign in success, update UI with the signed-in user's information
                    Log.d(Tag, "signInWithCredential:success")
                    val user = auth.currentUser
                    activity.shortToast("SignInSuccess")
                } else {
                    // If sign in fails, display a message to the user.
                    Log.w(Tag, "signInWithCredential:failure", task.exception)
                    activity.shortToast("SignInFailed")
                }

            }
    }

    fun signInGoogle(activity: Activity){
        val signInIntent = googleSignInClient.signInIntent
        activity.startActivityForResult(signInIntent, Constants.RC_SIGN_IN)
    }

    fun signOutGoogle(activity: Activity){
        googleSignInClient.signOut().addOnCompleteListener(activity){
            //Update ui
        }
    }

}