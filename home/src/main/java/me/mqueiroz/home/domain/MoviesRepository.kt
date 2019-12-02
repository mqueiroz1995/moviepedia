package me.mqueiroz.home.domain

import io.reactivex.Single
import me.mqueiroz.home.data.MediaType
import me.mqueiroz.home.data.TimeWindow

interface MoviesRepository {

    fun getNowPlaying(mediaType: MediaType, timeWindow: TimeWindow): Single<List<Movie>>
}