package me.mqueiroz.home.presentation

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import jp.wasabeef.glide.transformations.RoundedCornersTransformation
import kotlinx.android.synthetic.main.list_item_home.view.*

class MovieListItemViewHolder(
    itemView: View
) : RecyclerView.ViewHolder(itemView) {

    fun bind(movie: MovieListItemState) {
        Glide.with(itemView)
            .load(movie.poster?.optimalSize)
            .apply(RequestOptions.bitmapTransform(RoundedCornersTransformation(RADIUS, 0)))
            .into(itemView.poster)

        itemView.title.text = movie.name
        itemView.rate.text = movie.rate.toString()
    }

    companion object {
        private const val RADIUS = 32
    }
}
