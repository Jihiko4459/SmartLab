package com.example.smartlab

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.smartlab.models.LoadNews

class NewsAdapter(private val ctx: Context, private val data: List<LoadNews>) :
    RecyclerView.Adapter<NewsAdapter.Link>() {
    class Link(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val load_name: TextView = itemView.findViewById(R.id.name2)
        val load_price: TextView = itemView.findViewById(R.id.price)
        val load_description: TextView = itemView.findViewById(R.id.description)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Link {
        val connect = LayoutInflater.from(ctx).inflate(R.layout.cards_item, parent, false)
        return Link(connect)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: Link, position: Int) {
        holder.load_name.text = data[position].name
        holder.load_description.text=data[position].description
        holder.load_price.text=data[position].price
    }
}
