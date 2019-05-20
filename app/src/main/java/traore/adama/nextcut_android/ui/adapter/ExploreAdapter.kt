package traore.adama.nextcut_android.ui.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.item_category.view.*
import traore.adama.nextcut_android.R
import traore.adama.nextcut_android.database.model.Haircut

class ExploreAdapter : RecyclerView.Adapter<ExploreAdapter.CategoryHolder>(){
    var items: List<Haircut> = ArrayList()

    fun resetData(items: List<Haircut>){
        this.items = items
    }

    override fun onCreateViewHolder(parent: ViewGroup, position: Int): CategoryHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_category, parent, false)

        return CategoryHolder(view)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: CategoryHolder, position: Int) {
        val item = items.get(position)
        holder.setItems(item)
    }

    class CategoryHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

        val imgCategory = itemView.imv_category

        fun setItems(item: Haircut){
            //todo: Set data to item
        }
    }
}