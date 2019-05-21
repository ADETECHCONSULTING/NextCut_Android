package traore.adama.nextcut_android.ui.adapter

import android.graphics.Color
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import traore.adama.nextcut_android.R
import traore.adama.nextcut_android.database.model.Nextcuter
import java.util.*
import kotlinx.android.synthetic.main.item_category.*
import kotlinx.android.synthetic.main.item_nextcutter.view.*

class NextcuterAdapter : RecyclerView.Adapter<NextcuterAdapter.NextcuterHolder>() {

    private var data: List<Nextcuter> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NextcuterHolder {
        return NextcuterHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.item_nextcutter, parent, false)
        )
    }

    override fun getItemCount() = data.size

    override fun onBindViewHolder(holder: NextcuterHolder, position: Int) = holder.bind(data[position])

    fun swapData(data: List<Nextcuter>) {
        this.data = data
        notifyDataSetChanged()
    }

    class NextcuterHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(item: Nextcuter) = with(itemView) {

            txvPrice.text = "${item.price} €"
            imvImage.setBackgroundColor(randomColor())

            setOnClickListener {
                // TODO: Handle on click
            }
        }

        fun randomColor():Int{

            val r = (0xff * Math.random()).toInt()
            val g = (0xff * Math.random()).toInt()
            val b = (0xff * Math.random()).toInt()

            return Color.rgb(r, g, b)
        }
    }
}