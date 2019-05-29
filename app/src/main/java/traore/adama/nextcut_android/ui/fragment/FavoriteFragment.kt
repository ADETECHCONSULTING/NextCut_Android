package traore.adama.nextcut_android.ui.fragment

import android.arch.lifecycle.*
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.GridLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.activity_splash_screen.*
import kotlinx.android.synthetic.main.fragment_list.*
import kotlinx.android.synthetic.main.fragment_nextcuters.*
import traore.adama.nextcut_android.R
import traore.adama.nextcut_android.database.model.Nextcuter
import traore.adama.nextcut_android.interfaces.IListItemClick
import traore.adama.nextcut_android.ui.adapter.NextcuterAdapter
import traore.adama.nextcut_android.viewmodel.FavoriteViewModel

class FavoriteFragment : Fragment(), IListItemClick<Nextcuter> {

    private lateinit var adapter: NextcuterAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view: View = inflater.inflate(R.layout.fragment_list, container, false)
        return view
    }


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        val viewModel = ViewModelProviders.of(this).get(FavoriteViewModel::class.java)

        observeViewModel(viewModel)

    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        adapter = NextcuterAdapter(this)
        rcvCategory.setHasFixedSize(true)
        rcvCategory.layoutManager = GridLayoutManager(context, resources.getInteger(R.integer.column_count))
        rcvCategory.adapter = adapter

    }

    fun observeViewModel(viewModel: FavoriteViewModel){
        //update list when data changes
        viewModel.getFavorites().observe(this, Observer<List<Nextcuter>> { list ->
            list?.let {
                adapter.swapData(list)
            }
        } )
    }

    override fun itemClicked(item: Nextcuter, view: View) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}