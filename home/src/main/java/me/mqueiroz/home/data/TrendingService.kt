package me.mqueiroz.home.data

import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path

interface TrendingService {

    @GET("trending/{media_type}/{time_window}")
    fun getTrending(
        @Path("media_type") mediaType: MediaType,
        @Path("time_window") timeWindow: TimeWindow
    ): Single<TrendingResponse>
}