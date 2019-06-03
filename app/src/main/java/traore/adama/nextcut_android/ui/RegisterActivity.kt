package traore.adama.nextcut_android.ui

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import traore.adama.nextcut_android.R
import kotlinx.android.synthetic.main.activity_register.*

class RegisterActivity : BaseActivity() {

    val Tag: String = RegisterActivity::class.java.simpleName;

    /**
     * Launch method -> start activity
     */
    companion object {
        fun launch(activity: Activity){
            activity.startActivity(Intent(activity, RegisterActivity::class.java))
            activity.overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

    }

    override fun onStart() {
        super.onStart()

        txvLoginLink.setOnClickListener {
            LoginActivity.launch(this)
        }
    }
}