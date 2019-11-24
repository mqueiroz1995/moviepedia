package me.mqueiroz.core_presentation.resources

import android.content.Context
import android.util.TypedValue
import kotlin.math.roundToInt

fun StringResource.resolve(context: Context): String {
    return context.getString(this.id, *this.args)
}

fun DensityIndependentPixel.toPx(context: Context): Int {
    return TypedValue.applyDimension(
        TypedValue.COMPLEX_UNIT_DIP, value, context.resources.displayMetrics
    ).roundToInt()
}