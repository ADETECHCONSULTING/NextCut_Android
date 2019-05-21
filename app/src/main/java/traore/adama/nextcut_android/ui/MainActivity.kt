package traore.adama.nextcut_android.ui

import android.animation.LayoutTransition
import android.app.Activity
import android.content.Context
import android.content.Intent
import android.graphics.PorterDuff
import android.graphics.PorterDuffColorFilter
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.design.widget.TabLayout
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.content.ContextCompat
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.view.MenuItem
import traore.adama.nextcut_android.R
import kotlinx.android.synthetic.main.activity_main.*
import traore.adama.nextcut_android.database.model.Nextcuter
import traore.adama.nextcut_android.extensions.logd
import traore.adama.nextcut_android.ui.adapter.MyPagerAdapter
import traore.adama.nextcut_android.ui.adapter.NextcuterAdapter
import traore.adama.nextcut_android.ui.fragment.CartFragment
import traore.adama.nextcut_android.ui.fragment.FavoriteFragment
import traore.adama.nextcut_android.ui.fragment.HomeFragment
import java.util.*
import kotlin.collections.ArrayList

class MainActivity : BaseActivity() {

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


    //region lifecycle
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Log.d(Tag, "=== OnCreate MainActivity ===")

        bottomNavigation.setOnNavigationItemSelectedListener { menuItem -> updateFragment(menuItem.itemId) }

        //Si l'activity vient d'être init alors on met le curseur du bottomnav sur le Home par défaut
        if(savedInstanceState == null) {
            bottomNavigation.selectedItemId = R.id.action_home
        }
    }

    override fun onBackPressed() {
        val fragmentManager = supportFragmentManager
        if (fragmentManager.backStackEntryCount > 1) {
            fragmentManager.popBackStack()
        } else {
            finish()
        }
    }
    //endregion


    //region functions
    fun setToolbarTitle(title: String){
        toolbar.setTitle(title)
    }

    fun updateFragment(itemId: Int) : Boolean{
        when(itemId){
            R.id.action_fav -> changeFragment(FavoriteFragment())
            R.id.action_home -> changeFragment(HomeFragment())
            R.id.action_cart -> changeFragment(CartFragment())
            else -> {
                changeFragment(HomeFragment())
            }
        }
        return true
    }

    fun changeFragment(f: Fragment, cleanStack: Boolean = false){
        val ft = supportFragmentManager.beginTransaction()
        if(cleanStack)
            clearBackStack()

        ft.setCustomAnimations(R.anim.abc_fade_in, R.anim.abc_fade_out, R.anim.abc_popup_enter, R.anim.abc_popup_exit)
        ft.replace(R.id.ctnFragment, f)
        ft.addToBackStack(null)
        ft.commit()
    }

    fun clearBackStack(){
        val manager = supportFragmentManager
        if(manager.backStackEntryCount > 0){
            val first = manager.getBackStackEntryAt(0)
            manager.popBackStack(first.id, FragmentManager.POP_BACK_STACK_INCLUSIVE)
        }
    }
    //endregion


}
