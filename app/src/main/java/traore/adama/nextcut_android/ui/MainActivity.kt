package traore.adama.nextcut_android.ui

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.coordinatorlayout.widget.CoordinatorLayout
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import android.util.Log
import android.widget.FrameLayout
import kotlinx.android.synthetic.main.activity_main.*
import traore.adama.nextcut_android.R
import traore.adama.nextcut_android.ui.fragment.CartFragment
import traore.adama.nextcut_android.ui.fragment.ExploreFragment
import traore.adama.nextcut_android.ui.fragment.FavoriteFragment
import traore.adama.nextcut_android.ui.fragment.HomeFragment

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



    fun updateFragment(itemId: Int) : Boolean{
        when(itemId){
            R.id.action_fav -> changeFragment(ExploreFragment())
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
