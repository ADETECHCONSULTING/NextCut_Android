package traore.adama.nextcut_android.ui.fragment

import android.content.Context
import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.design.widget.CoordinatorLayout
import android.support.v4.app.Fragment
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import kotlinx.android.synthetic.main.activity_main.*
import traore.adama.nextcut_android.R
import traore.adama.nextcut_android.database.model.Nextcuter
import traore.adama.nextcut_android.ui.adapter.ExploreAdapter
import traore.adama.nextcut_android.ui.adapter.NextcuterAdapter
import java.util.*
import kotlinx.android.synthetic.main.fragment_nextcuters.*
import traore.adama.nextcut_android.ui.MainActivity

class HomeFragment : Fragment() {

    private var behavior: CoordinatorLayout.Behavior<BottomNavigationView>? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_nextcuters, container, false)
    }



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        val adapter = NextcuterAdapter()
        rcvMain.setHasFixedSize(true)
        rcvMain.layoutManager = GridLayoutManager(context, resources.getInteger(R.integer.column_count))
        rcvMain.adapter = adapter



        //adapter.swapData(list)

        setToolbarTitle(getString(R.string.app_name))
    }

    //region functions
    fun setToolbarTitle(title: String){
        toolbar.setTitle(title)
    }

}