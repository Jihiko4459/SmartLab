package com.example.smartlab

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.widget.AppCompatButton
import androidx.recyclerview.widget.RecyclerView
import com.example.smartlab.models.LoadCatalog

class CategoryAdapter(private val ctx: Context, private val data: List<LoadCatalog>) :
    RecyclerView.Adapter<CategoryAdapter.Link>() {
    class Link(itemView:View):RecyclerView.ViewHolder(itemView) {
        val cat:AppCompatButton=itemView.findViewById(R.id.category)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Link {
        val root = LayoutInflater.from(ctx).inflate(R.layout.category_item, parent, false)
        return Link(root)
    }

    override fun onBindViewHolder(holder: Link, position: Int) {
        holder.cat.text= data[position].category
//        holder.itemView.setOnClickListener {
//            holder.cat.isSelected=true
//        }
    }

    override fun getItemCount(): Int {
        return data.size
    }

}
