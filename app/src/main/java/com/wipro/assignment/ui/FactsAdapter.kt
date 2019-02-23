package com.wipro.assignment.ui

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import com.wipro.assignment.R
import com.wipro.assignment.rest.model.Facts
import kotlinx.android.synthetic.main.facts_item.view.*

/**
 * Created by krishnas on 2/22/2019.
 */
class FactsAdapter(private val context: Context, val facts: MutableList<Facts.Row>) : RecyclerView.Adapter<FactsAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(context).inflate(R.layout.facts_item, parent, false)
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindViews(facts[position])
    }

    override fun getItemCount(): Int {
        return facts.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bindViews(row: Facts.Row) {
            itemView.title.text = row.title
            itemView.description.text = row.description
            if (row.imageHref != null) {
                Picasso.with(itemView.factImage.context)
                        .load(row.imageHref)
                        .placeholder(R.drawable.place_holder)
                        .resize(context.resources.getDimensionPixelSize(R.dimen.image_width), context.resources.getDimensionPixelSize(R.dimen.image_height))
                        .into(itemView.factImage)
            } else {
                itemView.factImage.setImageResource(R.drawable.place_holder)
            }
        }
    }
}