package traore.adama.nextcut_android.ui.adapter

import android.app.Application
import android.graphics.Color
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import kotlinx.android.synthetic.main.item_nextcutter.view.*
import traore.adama.nextcut_android.R
import traore.adama.nextcut_android.database.model.Nextcuter
import traore.adama.nextcut_android.databinding.ItemNextcutterBinding
import traore.adama.nextcut_android.interfaces.IListItemClick
import traore.adama.nextcut_android.ui.MainActivity
import traore.adama.nextcut_android.utils.extensions.shortToast
import traore.adama.nextcut_android.viewmodel.NextcuterListItemViewModel
import java.util.*

class NextcuterAdapter(private val application: Application) : RecyclerView.Adapter<NextcuterAdapter.NextcuterHolder>() {

    private var data: List<Nextcuter> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NextcuterHolder {
        val binding: ItemNextcutterBinding = DataBindingUtil.
            inflate(LayoutInflater.from(parent.context), R.layout.item_nextcutter, parent, false )
        return NextcuterHolder(binding, application)
    }

    override fun getItemCount() = data.size

    override fun onBindViewHolder(holder: NextcuterHolder, pos: Int) {
        holder.bind(data[pos])
    }
    fun swapData(data: List<Nextcuter>) {
        this.data = data
        notifyDataSetChanged()
    }

    class NextcuterHolder(private val binding: ItemNextcutterBinding, application: Application) : RecyclerView.ViewHolder(binding.root), View.OnClickListener {
        private val viewModel = NextcuterListItemViewModel(application)

        init {
            binding.root.setOnClickListener(this)
        }

        fun bind(item: Nextcuter) {
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