package traore.adama.nextcut_android.ui.fragment

import android.arch.lifecycle.*
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.GridLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_nextcuters.*
import traore.adama.nextcut_android.R
import traore.adama.nextcut_android.database.model.Nextcuter
import traore.adama.nextcut_android.ui.adapter.NextcuterAdapter
import traore.adama.nextcut_android.viewmodel.HomeViewModel

class HomeFragment : Fragment(), LifecycleOwner {
    private lateinit var adapter : NextcuterAdapter
    private lateinit var lifecycleRegistry: LifecycleRegistry

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        lifecycleRegistry = LifecycleRegistry(this)
        lifecycleRegistry.markState(Lifecycle.State.CREATED)
        return inflater.inflate(R.layout.fragment_nextcuters, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        lifecycleRegistry.markState(Lifecycle.State.STARTED)

        adapter = NextcuterAdapter()
        rcvMain.setHasFixedSize(true)
        rcvMain.layoutManager = GridLayoutManager(context, resources.getInteger(R.integer.column_count))
        rcvMain.adapter = adapter

        setToolbarTitle(getString(R.string.app_name))
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        val viewModel = ViewModelProviders.of(this).get(HomeViewModel::class.java)

        observeViewModel(viewModel)
    }

    override fun onDestroyView() {
        super.onDestroyView()

        lifecycleRegistry.markState(Lifecycle.State.DESTROYED)
    }

    //region functions
    fun setToolbarTitle(title: String){
        toolbar.title = title
    }


    fun observeViewModel(viewModel: HomeViewModel){
        //update list when data changes
        viewModel.getNextcuters().observe(this, Observer<List<Nextcuter>> { list ->
            list?.let {
                adapter.swapData(list)
            }
        } )
    }

}