package me.mqueiroz.home.data

import com.squareup.moshi.Json

data class TrendingResponse(
    @Json(name = "page") val page: Int?,
    @Json(name = "results") val results: List<Result>?,
    @Json(name = "total_pages") val totalPages: Int?,
    @Json(name = "total_results") val totalResults: Int?
) {
    data class Result(
        @Json(name = "id") val id: Int?,
        @Json(name = "title") val title: String?,
        @Json(name = "overview") val overview: String?,
        @Json(name = "release_date") val releaseDate: String?,
        @Json(name = "media_type") val mediaType: String?,
        @Json(name = "poster_path") val poster: String?,
        @Json(name = "backdrop_path") val backdrop: String?,
        @Json(name = "genre_ids") val genres: List<Int>?,
        @Json(name = "popularity") val popularity: Float?,
        @Json(name = "vote_count") val numVotes: Int?,
        @Json(name = "vote_average") val score: Float?,
        @Json(name = "original_title") val originalTitle: String?,
        @Json(name = "original_language") val originalLanguage: String?,
        @Json(name = "adult") val isAdult: Boolean?,
        @Json(name = "video") val hasVideo: Boolean?
    )
}