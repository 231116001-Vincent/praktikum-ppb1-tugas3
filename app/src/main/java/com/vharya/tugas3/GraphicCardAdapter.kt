package com.vharya.tugas3

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.View.OnClickListener
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class GraphicCardAdapter(
    val context: Context,
    val items: ArrayList<GraphicCard>,
) : RecyclerView.Adapter<GraphicCardAdapter.GraphicCardViewHolder>() {

    inner class GraphicCardViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var imageView: ImageView = itemView.findViewById(R.id.gc_image)
        var textViewName: TextView = itemView.findViewById(R.id.gc_name)
        var textViewBrand: TextView = itemView.findViewById(R.id.gc_brand)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GraphicCardViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.list_item, parent, false)
        return GraphicCardViewHolder(view)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: GraphicCardViewHolder, position: Int) {
        val item = items[position]

        holder.imageView.setImageResource(item.image)
        holder.textViewName.text = item.name
        holder.textViewBrand.text = item.brand

        holder.itemView.setOnClickListener {
            val intent = Intent(context, DetailsActivity::class.java)
            intent.putExtra("gpu", item)
            context.startActivity(intent)
        }
    }
}