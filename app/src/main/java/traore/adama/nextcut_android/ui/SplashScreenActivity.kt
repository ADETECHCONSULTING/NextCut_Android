package traore.adama.nextcut_android.ui

import android.databinding.DataBindingUtil
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import traore.adama.nextcut_android.R
import traore.adama.nextcut_android.databinding.ActivitySplashScreenBinding

class SplashScreenActivity : AppCompatActivity() {

    lateinit var binding: ActivitySplashScreenBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_splash_screen)

        //just for now

    }

}
