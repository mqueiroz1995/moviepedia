package me.mqueiroz.home.presentation

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.list_item_home.view.*
import me.mqueiroz.home.R

class HomeListAdapter : RecyclerView.Adapter<HomeListAdapter.HomeListViewHolder>() {

    var elements: List<String> = emptyList()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeListViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_item_home, parent, false)

        return HomeListViewHolder(view)
    }

    override fun onBindViewHolder(holder: HomeListViewHolder, position: Int) {
        holder.bind(elements[position])
    }

    override fun getItemCount() = elements.size

    inner class HomeListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(element: String) {
            itemView.title.text = element
        }
    }
}