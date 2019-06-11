package traore.adama.nextcut_android.ui

import android.app.Activity
import android.arch.lifecycle.ViewModelProviders
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.facebook.AccessToken
import com.facebook.CallbackManager
import com.facebook.FacebookCallback
import com.facebook.FacebookException
import com.facebook.login.LoginResult
import com.google.firebase.auth.FacebookAuthProvider
import traore.adama.nextcut_android.R
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.button_facebook.*
import traore.adama.nextcut_android.utils.extensions.shortToast
import traore.adama.nextcut_android.viewmodel.LoginViewModel

class LoginActivity : AppCompatActivity() {

    val Tag: String = LoginActivity::class.java.simpleName;
    private lateinit var callbackManager: CallbackManager
    private lateinit var loginViewModel: LoginViewModel


    /**
     * Launch method -> start activity
     */
    companion object {
        fun launch(activity: Activity) {
            activity.startActivity(Intent(activity, LoginActivity::class.java))
            activity.overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        loginViewModel = ViewModelProviders.of(this).get(LoginViewModel::class.java)

        callbackManager = CallbackManager.Factory.create()

        btnFacebookConnexion.setOnClickListener {
            loginButton.performClick()
        }

        btnGoogleConnect.setOnClickListener {
            loginViewModel.signInGoogle(this)
        }

        loginButton.setReadPermissions("email", "public_profile")
        loginButton.registerCallback(callbackManager, object : FacebookCallback<LoginResult> {
            override fun onSuccess(result: LoginResult) {
                handleFacebookAccessToken(result.accessToken)
            }

            override fun onError(error: FacebookException?) {
                Log.d(Tag, "facebook:onError")
            }

            override fun onCancel() {
                Log.d(Tag, "facebook:onCancel")
            }
        })
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        //Pass the activity result back to the Facebook SDK
        callbackManager.onActivityResult(requestCode, resultCode, data)

        //Pass the activity result back to the Google SDK
        loginViewModel.activityForResultLogin(requestCode, resultCode, data, this)
    }

    override fun onStart() {
        super.onStart()

        txvRegisterLink.setOnClickListener {
            RegisterActivity.launch(this)
        }
    }


    private fun handleFacebookAccessToken(token: AccessToken){
        Log.d(Tag, "handleFacebookAccessToken:$token")

        val credential = FacebookAuthProvider.getCredential(token.token)
        loginViewModel.auth.signInWithCredential(credential)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    // Sign in success, get user from id
                    shortToast("OK")
                } else {
                    shortToast("NOT OK")
                }
            }
    }

}
