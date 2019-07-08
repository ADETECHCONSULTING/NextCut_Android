package traore.adama.nextcut_android.ui.adapter

import android.app.Application
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import traore.adama.nextcut_android.R
import traore.adama.nextcut_android.database.model.Haircut
import traore.adama.nextcut_android.databinding.ItemHaircutBinding
import traore.adama.nextcut_android.ui.MainActivity
import traore.adama.nextcut_android.utils.extensions.shortToast
import traore.adama.nextcut_android.viewmodel.HaircutListItemViewModel
import java.util.*

class HaircutAdapter(private val application: Application) : RecyclerView.Adapter<HaircutAdapter.HaircutHolder>() {

    private var data: List<Haircut> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HaircutHolder {
        val binding: ItemHaircutBinding =
            DataBindingUtil.inflate(LayoutInflater.from(parent.context), R.layout.item_haircut, parent, false)
        return HaircutHolder(binding, application)
    }

    override fun getItemCount() = data.size

    override fun onBindViewHolder(holder: HaircutHolder, pos: Int) {
        holder.bind(data[pos])
    }

    fun swapData(data: List<Haircut>) {
        this.data = data
        notifyDataSetChanged()
    }

    class HaircutHolder(private val binding: ItemHaircutBinding, application: Application) :
        RecyclerView.ViewHolder(binding.root), View.OnClickListener {
        private val viewModel = HaircutListItemViewModel(application)

        init {
            binding.root.setOnClickListener(this)
        }

        fun bind(item: Haircut) {
            viewModel.bind(item)
            binding.viewModel = viewModel
        }

        override fun onClick(v: View?) {
            val activity = v?.context as MainActivity
            //activity.changeFragment(DetailFragment.newInstance(viewModel.movieId.value))
            activity.shortToast(v.id.toString())
        }


    }
}