package me.mqueiroz.home.data

import io.reactivex.Single

class TrendingRepository(private val service: TrendingService) {

    fun getTrending(mediaType: MediaType, timeWindow: TimeWindow): Single<TrendingResponse> {
        return service.getTrending(mediaType, timeWindow)
    }
}