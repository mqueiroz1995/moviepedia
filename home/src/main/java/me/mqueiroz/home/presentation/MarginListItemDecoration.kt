package me.mqueiroz.home.presentation

import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import me.mqueiroz.core_presentation.resources.DensityIndependentPixel
import me.mqueiroz.core_presentation.resources.toPx


class MarginListItemDecoration(
    private val direction: Direction,
    private val size: DensityIndependentPixel = DensityIndependentPixel(16f)
) : RecyclerView.ItemDecoration() {

    enum class Direction {
        TOP,
        RIGHT,
        BOTTOM,
        LEFT
    }

    override fun getItemOffsets(outRect: Rect, view: View, parent: RecyclerView, state: RecyclerView.State) {
        when (direction) {
            Direction.TOP -> outRect.top = size.toPx(view.context)
            Direction.RIGHT -> outRect.right = size.toPx(view.context)
            Direction.BOTTOM -> outRect.bottom = size.toPx(view.context)
            Direction.LEFT -> outRect.left = size.toPx(view.context)
        }
    }
}
