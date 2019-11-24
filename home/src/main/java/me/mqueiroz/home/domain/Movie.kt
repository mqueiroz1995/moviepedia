package me.mqueiroz.home.domain

data class Movie(
    val id: Int,
    val name: String,
    val overview: String,
    val releaseDate: String,
    val poster: Image?,
//    val mediaType: String,
//    val backdrop: String,
//    val genres: List<Int>,
//    val popularity: Float,
//    val numVotes: Int,
    val rate: Float
//    val originalName: String,
//    val originalLanguage: String,
//    val isAdult: Boolean,
//    val hasVideo: Boolean
)