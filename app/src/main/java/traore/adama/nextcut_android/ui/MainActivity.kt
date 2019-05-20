package traore.adama.nextcut_android.ui

import android.animation.LayoutTransition
import android.app.Activity
import android.content.Context
import android.content.Intent
import android.graphics.PorterDuff
import android.graphics.PorterDuffColorFilter
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.TabLayout
import android.support.v4.content.ContextCompat
import android.util.Log
import traore.adama.nextcut_android.R
import kotlinx.android.synthetic.main.activity_main.*
import traore.adama.nextcut_android.extensions.logd
import traore.adama.nextcut_android.ui.adapter.MyPagerAdapter

class MainActivity : BaseActivity() {

    val myPagerAdapter:MyPagerAdapter by lazy {
        MyPagerAdapter(supportFragmentManager, this)
    }
    val Tag: String = MainActivity::class.java.simpleName;

    /**
     * Launch method -> start activity
     */
    companion object {
        fun launch(activity: Activity){
            activity.startActivity(Intent(activity, MainActivity::class.java))
            activity.overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out)
        }
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Log.d(Tag, "=== OnCreate MainActivity ===")


    }

    fun setToolbarTitle(title: String){
        toolbar.setTitle(title)
    }

}
