package me.mqueiroz.home.data

import okhttp3.Interceptor
import okhttp3.Response

class GlobalParamsInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()

        val url = request.url.newBuilder()
            .addQueryParameter("api_key", "693d7f88796c8ef92c2cc2c279ffbb20")
            .build()

        val interceptedRequest = request.newBuilder()
            .url(url)
            .build()

        return chain.proceed(interceptedRequest)
    }
}