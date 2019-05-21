package traore.adama.nextcut_android.ui.adapter

import android.app.Activity
import android.content.Context
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentStatePagerAdapter
import traore.adama.nextcut_android.R
import traore.adama.nextcut_android.ui.MainActivity
import traore.adama.nextcut_android.ui.fragment.ExploreFragment
import traore.adama.nextcut_android.ui.fragment.FavoriteFragment

class MyPagerAdapter(fm: FragmentManager, val activity: Activity) : FragmentStatePagerAdapter(fm) {
    val tabCount:Int = 2
    val iconsResId = arrayOf(R.drawable.ic_cissor, R.drawable.ic_favorite)

    override fun getItem(position: Int): Fragment? {
        when(position){
            0 -> {
                (activity as MainActivity).setToolbarTitle(activity.getString(R.string.title_explore))
                return ExploreFragment()
            }
            1 -> {
                (activity as MainActivity).setToolbarTitle(activity.getString(R.string.favorites))
                return FavoriteFragment()
            }
            else -> return null
        }
    }

    override fun getCount(): Int {
        return tabCount
    }


}