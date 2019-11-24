package me.mqueiroz.home.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import me.mqueiroz.home.R

class HomeListAdapter : RecyclerView.Adapter<MovieListItemViewHolder>() {

    var elements: List<MovieListItemState> = emptyList()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieListItemViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_item_home, parent, false)

        return MovieListItemViewHolder(view)
    }

    override fun onBindViewHolder(holder: MovieListItemViewHolder, position: Int) {
        holder.bind(elements[position])
    }

    override fun getItemCount() = elements.size

}