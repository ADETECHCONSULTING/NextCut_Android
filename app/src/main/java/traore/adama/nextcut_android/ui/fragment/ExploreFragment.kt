package traore.adama.nextcut_android.ui.fragment


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.StringRes
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar
import traore.adama.nextcut_android.R
import traore.adama.nextcut_android.databinding.FragmentExploreBinding
import traore.adama.nextcut_android.ui.adapter.ExploreAdapter
import traore.adama.nextcut_android.viewmodel.ExploreViewModel

class ExploreFragment : Fragment() {

    private lateinit var binding: FragmentExploreBinding
    private lateinit var viewModel: ExploreViewModel
    private var errorSnackbar: Snackbar? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_explore, container, false)
        val view = binding.root

        binding.rcvHaircuts.layoutManager = LinearLayoutManager(activity, RecyclerView.VERTICAL, false)

        viewModel = ViewModelProviders.of(this).get(ExploreViewModel::class.java)
        viewModel.errorMessage.observe(this, Observer {errorMessage ->
            if (errorMessage != null)
                showError(errorMessage)
            else
                hideError()

        })


        //Set values to layout
        binding.viewModel = viewModel


        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val adapter = ExploreAdapter()
        binding.rcvHaircuts.adapter = adapter

    }


    private fun showError(@StringRes errorMessage:Int){
        errorSnackbar = Snackbar.make(binding.root, errorMessage, Snackbar.LENGTH_INDEFINITE)
        errorSnackbar?.setAction(R.string.retry, viewModel.errorClickListener)
        errorSnackbar?.show()
    }

    private fun hideError(){
        errorSnackbar?.dismiss()
    }

}
