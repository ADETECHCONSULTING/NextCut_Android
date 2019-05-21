package traore.adama.nextcut_android.ui.fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import traore.adama.nextcut_android.R
import traore.adama.nextcut_android.database.model.Nextcuter
import traore.adama.nextcut_android.ui.adapter.ExploreAdapter
import traore.adama.nextcut_android.ui.adapter.NextcuterAdapter
import java.util.*
import kotlinx.android.synthetic.main.fragment_nextcuters.*

class HomeFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_nextcuters, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        val adapter = NextcuterAdapter()
        rcvMain.setHasFixedSize(true)
        rcvMain.layoutManager = GridLayoutManager(context, resources.getInteger(R.integer.column_count))
        rcvMain.adapter = adapter

        val list = ArrayList<Nextcuter>()
        val random = Random()
        list.add(Nextcuter(10 + (120 - 10) * random.nextInt()))
        list.add(Nextcuter(10 + (120 - 10) * random.nextInt()))
        list.add(Nextcuter(10 + (120 - 10) * random.nextInt()))
        list.add(Nextcuter(10 + (120 - 10) * random.nextInt()))
        list.add(Nextcuter(10 + (120 - 10) * random.nextInt()))
        list.add(Nextcuter(10 + (120 - 10) * random.nextInt()))
        list.add(Nextcuter(10 + (120 - 10) * random.nextInt()))
        list.add(Nextcuter(10 + (120 - 10) * random.nextInt()))
        list.add(Nextcuter(10 + (120 - 10) * random.nextInt()))
        list.add(Nextcuter(10 + (120 - 10) * random.nextInt()))
        list.add(Nextcuter(10 + (120 - 10) * random.nextInt()))
        list.add(Nextcuter(10 + (120 - 10) * random.nextInt()))
        list.add(Nextcuter(10 + (120 - 10) * random.nextInt()))
        list.add(Nextcuter(10 + (120 - 10) * random.nextInt()))
        list.add(Nextcuter(10 + (120 - 10) * random.nextInt()))
        list.add(Nextcuter(10 + (120 - 10) * random.nextInt()))

        adapter.swapData(list)

    }
}