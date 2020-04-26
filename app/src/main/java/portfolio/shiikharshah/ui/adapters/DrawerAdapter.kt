package portfolio.shiikharshah.ui.adapters

import android.app.Activity
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.nav_drawer_row.view.*
import portfolio.shiikharshah.R
import portfolio.shiikharshah.ui.datamodels.DrawerItem
class DrawerAdapter(private val data: List<DrawerItem>) : RecyclerView.Adapter<DrawerAdapter.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.nav_drawer_row, parent,false)
        return MyViewHolder(view)
    }
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val current = data[position]
        holder.title.text = current.itemName
    }
    override fun getItemCount(): Int {
        return data.size
    }
    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var title = itemView.tv_title
        init {
        }
    }





}