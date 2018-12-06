package traore.adama.nextcut_android.ui

import android.animation.Animator
import android.databinding.DataBindingUtil
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.view.animation.Animation
import traore.adama.nextcut_android.R
import traore.adama.nextcut_android.databinding.ActivitySplashScreenBinding

class SplashScreenActivity : AppCompatActivity(), Animator.AnimatorListener {


    //region AnimatorListenener methods
    override fun onAnimationRepeat(animation: Animator?) {
        Log.e("Animation:","repeat")
    }

    override fun onAnimationEnd(animation: Animator?) {
        Log.e("Animation:","end")
    }

    override fun onAnimationCancel(animation: Animator?) {
        Log.e("Animation:","cancel")
    }

    override fun onAnimationStart(animation: Animator?) {
        Log.e("Animation:","start")
    }
    //endregion

    lateinit var binding: ActivitySplashScreenBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        setTheme(R.style.AppTheme_NoTitleBar_FullScreen);
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_splash_screen)

        binding.animationView.setAnimation("nextcut_splash_mobile.json")
        binding.animationView.playAnimation()
        binding.animationView.addAnimatorListener(object: Animator.AnimatorListener{
            override fun onAnimationCancel(p0: Animator?) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

            override fun onAnimationRepeat(p0: Animator?) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

            override fun onAnimationEnd(animation: Animator?, isReverse: Boolean) {
                super.onAnimationEnd(animation, isReverse)
            }

            override fun onAnimationEnd(p0: Animator?) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

            override fun onAnimationStart(animation: Animator?, isReverse: Boolean) {
                super.onAnimationStart(animation, isReverse)
            }

            override fun onAnimationStart(p0: Animator?) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }
        })
    }

}
