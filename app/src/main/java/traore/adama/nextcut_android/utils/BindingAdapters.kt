package traore.adama.nextcut_android.utils

import android.view.View
import android.widget.CheckBox
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatRatingBar
import androidx.databinding.BindingAdapter
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_nextcutter.view.*
import traore.adama.nextcut_android.R
import traore.adama.nextcut_android.utils.extensions.getParentActivity

@BindingAdapter("mutableVisibility")
fun setMutableVisibility(view: View, visibility: MutableLiveData<Int>?) {
    val parentActivity: AppCompatActivity? = view.getParentActivity()
    if (parentActivity != null && visibility != null) {
        visibility.observe(parentActivity, Observer { value -> view.visibility = value ?: View.VISIBLE })
    }
}

@BindingAdapter("mutableText")
fun setMutableText(view: TextView, text: MutableLiveData<String>?){
    val parentActivity: AppCompatActivity? = view.getParentActivity()
    if (parentActivity != null && text != null) {
        text.observe(parentActivity, Observer { value -> view.text = value ?: "" })
    }
}

@BindingAdapter("adapter")
fun setAdapter(view: RecyclerView, adapter: RecyclerView.Adapter<*>) {
    view.adapter = adapter
}

@BindingAdapter("picasso")
fun setPicasso(view: ImageView, text: MutableLiveData<String>?) {

    val parentActivity: AppCompatActivity? = view.getParentActivity()

    if (parentActivity != null && text != null) {

        text.observe(parentActivity, Observer {

            Picasso.get().load(text.value).into(view)

        })
    }
}

@BindingAdapter("background")
fun setImageViewBackground(view: ImageView, background: MutableLiveData<Int>?) {

    val parentActivity: AppCompatActivity? = view.getParentActivity()

    if (parentActivity != null && background != null) {

        background.observe(parentActivity, Observer {

            view.setBackgroundColor(background.value!!)

        })
    }
}

@BindingAdapter("mutableChecked")
fun setMutableChecked(view: CheckBox, bool: MutableLiveData<Boolean>?){
    val parentActivity: AppCompatActivity? = view.getParentActivity()
    if (parentActivity != null && bool != null) {
        bool.observe(parentActivity, Observer { value -> view.isChecked = value })
    }
}
