package traore.adama.nextcut_android.ui

import android.animation.Animator
import android.databinding.DataBindingUtil
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.util.Log
import traore.adama.nextcut_android.R
import traore.adama.nextcut_android.databinding.ActivitySplashScreenBinding

class SplashScreenActivity : AppCompatActivity(), Animator.AnimatorListener {


    override fun onAnimationRepeat(animation: Animator?) {
        Log.e("Animation:","repeat")
    }

    override fun onAnimationEnd(animation: Animator?) {
        Log.e("Animation:","end")

        MainActivity.launch(this)
    }

    override fun onAnimationCancel(animation: Animator?) {
        Log.e("Animation:","cancel")
    }

    override fun onAnimationStart(animation: Animator?) {
        Log.e("Animation:","start")
    }

    lateinit var binding: ActivitySplashScreenBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        setTheme(R.style.AppTheme_NoTitleBar_FullScreen);
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_splash_screen)

        binding.animationView.addAnimatorListener(this)

    }

}
