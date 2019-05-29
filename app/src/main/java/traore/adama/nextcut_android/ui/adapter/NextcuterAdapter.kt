package traore.adama.nextcut_android.ui.adapter

import android.graphics.Color
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.item_nextcutter.view.*
import traore.adama.nextcut_android.R
import traore.adama.nextcut_android.database.model.Nextcuter
import traore.adama.nextcut_android.interfaces.IListItemClick
import java.util.*

class NextcuterAdapter(var itemClick: IListItemClick<Nextcuter>) : RecyclerView.Adapter<NextcuterAdapter.NextcuterHolder>() {

    private var data: List<Nextcuter> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NextcuterHolder {
        return NextcuterHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.item_nextcutter, parent, false)
        )
    }

    override fun getItemCount() = data.size

    override fun onBindViewHolder(holder: NextcuterHolder, position: Int) = holder.bind(data[position], itemClick)

    fun swapData(data: List<Nextcuter>) {
        this.data = data
        notifyDataSetChanged()
    }

    class NextcuterHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(item: Nextcuter, itemClick: IListItemClick<Nextcuter>) = with(itemView) {

            txvPrice.text = "${item.price} €"
            txvBarberName.text = "${item.firstname} ${item.lastname}"
            imvImage.setBackgroundColor(randomColor())

            setOnClickListener {
                itemClick.itemClicked(item, it)
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