package me.mqueiroz.core_presentation.resources

import android.content.Context

fun StringResource.resolve(context: Context): String {
    return context.getString(this.id, *this.args)
}