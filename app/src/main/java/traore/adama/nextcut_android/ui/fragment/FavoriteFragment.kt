package traore.adama.nextcut_android.ui.fragment

import android.arch.lifecycle.*
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import traore.adama.nextcut_android.R
import traore.adama.nextcut_android.database.model.Nextcuter
import traore.adama.nextcut_android.ui.MainActivity
import traore.adama.nextcut_android.ui.adapter.NextcuterAdapter
import traore.adama.nextcut_android.viewmodel.FavoriteViewModel
import traore.adama.nextcut_android.viewmodel.HomeViewModel

class FavoriteFragment : Fragment(), LifecycleOwner {
    private lateinit var adapter: NextcuterAdapter
    private lateinit var lifecycleRegistry: LifecycleRegistry

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view: View = inflater.inflate(R.layout.fragment_list, container, false)
        lifecycleRegistry = LifecycleRegistry(this)
        lifecycleRegistry.markState(Lifecycle.State.CREATED)
        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        val viewModel = ViewModelProviders.of(this).get(FavoriteViewModel::class.java)

        observeViewModel(viewModel)

    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        lifecycleRegistry.markState(Lifecycle.State.STARTED)

    }

    fun observeViewModel(viewModel: FavoriteViewModel){
        //update list when data changes
        viewModel.getFavorites().observe(this, Observer<List<Nextcuter>> { list ->
            list?.let {
                adapter.swapData(list)
            }
        } )
    }


}