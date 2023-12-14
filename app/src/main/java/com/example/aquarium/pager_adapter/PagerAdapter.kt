package com.example.aquarium.pager_adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.aquarium.R
import com.example.aquarium.animal.Animal
import com.squareup.picasso.Picasso


class PagerAdapter (
    private val list: List<Animal>
) : RecyclerView.Adapter<PagerAdapter.PageViewHolder>(){

    class PageViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val image: ImageView = view.findViewById(R.id.image_view)
        val name: TextView = view.findViewById(R.id.tv_name)
        val description: TextView = view.findViewById(R.id.tv_description)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PageViewHolder {
        return PageViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.item_card, parent, false)
        )
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: PageViewHolder, position: Int) {
        val item = list[position]

        Picasso.get()
            .load(item.url)
            .into(holder.image)

        holder.name.text = item.name
        holder.description.text = item.description
    }
}