package traore.adama.nextcut_android.ui.adapter

import android.content.Context
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentStatePagerAdapter
import traore.adama.nextcut_android.R
import traore.adama.nextcut_android.ui.fragment.CategoryFragment
import traore.adama.nextcut_android.ui.fragment.FavoriteFragment

class MyPagerAdapter(fm: FragmentManager, val context: Context) : FragmentStatePagerAdapter(fm) {
    val tabCount:Int = 2

    override fun getItem(position: Int): Fragment? {
        when(position){
            0 -> return CategoryFragment()
            1 -> return FavoriteFragment()
            else -> return null
        }
    }

    override fun getCount(): Int {
        return tabCount
    }

    override fun getPageTitle(position: Int): CharSequence? {
        when(position){
            0 -> return context.getString(R.string.category)
            1 -> return context.getString(R.string.favorites)
            else -> return null
        }
    }

}