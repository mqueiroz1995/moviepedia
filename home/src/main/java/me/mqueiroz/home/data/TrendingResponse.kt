package me.mqueiroz.home.data

import com.squareup.moshi.Json

data class TrendingResponse(
    @field:Json(name = "page") val page: Int?,
    @field:Json(name = "results") val results: List<Result>?,
    @field:Json(name = "total_pages") val totalPages: Int?,
    @field:Json(name = "total_results") val totalResults: Int?
) {
    data class Result(
        @field:Json(name = "id") val id: Int,
        @field:Json(name = "name") val name: String,
        @field:Json(name = "overview") val overview: String?,
        @field:Json(name = "release_date") val releaseDate: String?,
        @field:Json(name = "media_type") val mediaType: String?,
        @field:Json(name = "poster_path") val poster: String?,
        @field:Json(name = "backdrop_path") val backdrop: String?,
        @field:Json(name = "genre_ids") val genres: List<Int>?,
        @field:Json(name = "popularity") val popularity: Float?,
        @field:Json(name = "vote_count") val numVotes: Int?,
        @field:Json(name = "vote_average") val rate: Float?,
        @field:Json(name = "original_name") val originalName: String?,
        @field:Json(name = "original_language") val originalLanguage: String?,
        @field:Json(name = "adult") val isAdult: Boolean?,
        @field:Json(name = "video") val hasVideo: Boolean?
    )
}