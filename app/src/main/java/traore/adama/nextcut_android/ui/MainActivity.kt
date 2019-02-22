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

        //activate the animation when children view are updated
        ctnMain.layoutTransition.enableTransitionType(LayoutTransition.CHANGING)

        //link the viewPager
        ctn_view_pager.adapter = myPagerAdapter
        ctn_view_pager.currentItem = 0

        setupTabLayout()
    }

    override fun onBackPressed() {
        if(ctn_view_pager.currentItem == 0)
            super.onBackPressed()
        else
            ctn_view_pager.currentItem = -1
    }

    fun setToolbarTitle(title: String){
        txv_title.text = title
    }

    /**
     * 1. Set viewpager on the tablayout
     * 2. Add listeners selected/unselected for TabIconTint colors
     * 3. Add icons
     */
    fun setupTabLayout(){
        val colorUnselect = ContextCompat.getColor(this@MainActivity, R.color.colorBlackDisabled)
        val colorSelect = ContextCompat.getColor(this@MainActivity, R.color.colorWhite)

        vg_tabLayout.setupWithViewPager(ctn_view_pager)

        vg_tabLayout.addOnTabSelectedListener(object:
        TabLayout.OnTabSelectedListener{

            override fun onTabSelected(tab: TabLayout.Tab?) {
                logd("Selected Tab ${tab?.position}")
                tab?.icon?.colorFilter = PorterDuffColorFilter(colorSelect, PorterDuff.Mode.SRC_IN)
            }

            override fun onTabReselected(tab: TabLayout.Tab?) {

            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {
                logd("Unselected Tab ${tab?.position}")
                tab?.icon?.colorFilter = PorterDuffColorFilter(colorUnselect, PorterDuff.Mode.SRC_IN)
            }
        })

        for (i in 0..vg_tabLayout.tabCount)
            vg_tabLayout.getTabAt(i)?.icon = baseContext.getDrawable(myPagerAdapter.iconsResId[i])

        vg_tabLayout.getTabAt(0)?.icon?.colorFilter = PorterDuffColorFilter(colorSelect, PorterDuff.Mode.SRC_IN)
    }
}
