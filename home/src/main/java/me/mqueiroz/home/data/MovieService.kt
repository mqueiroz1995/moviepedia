package me.mqueiroz.home.data

import io.reactivex.Single
import retrofit2.http.GET

interface MovieService {

    @GET("movie/now_playing")
    fun getNowPlaying(): Single<MovieServiceResponse>
}