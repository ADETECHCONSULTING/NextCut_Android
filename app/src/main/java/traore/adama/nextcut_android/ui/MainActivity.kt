package traore.adama.nextcut_android.ui

import android.animation.LayoutTransition
import android.app.Activity
import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import traore.adama.nextcut_android.R
import kotlinx.android.synthetic.main.activity_main.*
import traore.adama.nextcut_android.ui.adapter.MyPagerAdapter

class MainActivity : AppCompatActivity() {

    val myPagerAdapter:MyPagerAdapter by lazy {
        MyPagerAdapter(supportFragmentManager, this)
    }
    val Tag: String = MainActivity.javaClass.simpleName;

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

        //activate the animation when children view are updated
        ctnMain.layoutTransition.enableTransitionType(LayoutTransition.CHANGING)

        //link the viewPager
        ctn_view_pager.adapter = myPagerAdapter

        vg_tabLayout.setupWithViewPager(ctn_view_pager)
    }

    override fun onBackPressed() {
        if(ctn_view_pager.currentItem == 0)
            super.onBackPressed()
        else
            ctn_view_pager.currentItem = -1
    }
}
