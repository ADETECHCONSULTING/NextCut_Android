package traore.adama.nextcut_android.utils

import android.content.Context
import android.view.View
import androidx.databinding.BindingAdapter
import androidx.fragment.app.Fragment
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import traore.adama.nextcut_android.utils.extensions.getParentFragment

@BindingAdapter("mutableVisibility")
fun setMutableVisibility(view: View, visibility: MutableLiveData<Int>){
    val parentFragment: Fragment? = view.getParentFragment()
    if(parentFragment != null && visibility != null){
        visibility.observe(parentFragment, Observer {value ->
            view.visibility = value ?: View.VISIBLE
        })
    }

}