package me.mqueiroz.core_network

import okhttp3.Interceptor
import okhttp3.Response

class GlobalParamsInterceptor(
    private val key: String
) : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()

        val url = request.url.newBuilder()
            .addQueryParameter("api_key", key)
            .build()

        val interceptedRequest = request.newBuilder()
            .url(url)
            .build()

        return chain.proceed(interceptedRequest)
    }
}