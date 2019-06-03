package traore.adama.nextcut_android.viewmodel

import android.arch.lifecycle.ViewModel
import com.facebook.CallbackManager
import com.google.firebase.auth.FirebaseAuth

class LoginViewModel : ViewModel() {

    lateinit var auth: FirebaseAuth

    init {
        auth = FirebaseAuth.getInstance()
    }


}