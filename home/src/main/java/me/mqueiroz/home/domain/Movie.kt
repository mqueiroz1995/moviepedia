package me.mqueiroz.home.domain

data class Movie(
    val id: Int,
    val title: String,
    val overview: String,
    val releaseDate: String,
    val poster: Image?,
    val backdrop: Image?,
//    val genres: List<Int>,
    val rate: Float
)