package me.mqueiroz.home.domain

import io.reactivex.Single
import me.mqueiroz.home.data.MediaType
import me.mqueiroz.home.data.TimeWindow
import me.mqueiroz.home.data.TrendingResponse

interface TrendingRepository {

    fun getTrending(mediaType: MediaType, timeWindow: TimeWindow): Single<List<Movie>>
}