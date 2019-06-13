package traore.adama.nextcut_android.ui.fragment


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.fragment_explore.*
import traore.adama.nextcut_android.R
import traore.adama.nextcut_android.ui.MainActivity
import traore.adama.nextcut_android.ui.adapter.ExploreAdapter
import traore.adama.nextcut_android.viewmodel.ExploreViewModel

class ExploreFragment : Fragment() {

    private lateinit var viewModel: ExploreViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_explore, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val adapter = ExploreAdapter()

        rcvHaircuts.layoutManager = LinearLayoutManager(activity, RecyclerView.VERTICAL, false)
        rcvHaircuts.adapter = adapter

        viewModel = ViewModelProviders.of(this).get(ExploreViewModel::class.java)

    }


}
