package me.mqueiroz.home.presentation

import me.mqueiroz.home.domain.Image

data class MovieListItemState(
    val poster: Image?,
    val name: String,
    val rate: String
)