package me.mqueiroz.home

import io.reactivex.Single
import okhttp3.ResponseBody
import retrofit2.http.GET
import retrofit2.http.Query

interface TMDBService {

    @GET("trending/all/day")
    fun trending(@Query("api_key") key: String = "693d7f88796c8ef92c2cc2c279ffbb20"): Single<ResponseBody>
}