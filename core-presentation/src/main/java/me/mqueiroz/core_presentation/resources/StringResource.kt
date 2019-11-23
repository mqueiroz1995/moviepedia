package me.mqueiroz.core_presentation.resources

import androidx.annotation.StringRes

class StringResource(
    @StringRes val id: Int,
    vararg val args: Any
)