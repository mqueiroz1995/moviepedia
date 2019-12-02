package me.mqueiroz.network

import okhttp3.Interceptor
import okhttp3.Response
import org.koin.core.KoinComponent

class ApiKeyHeaderInterceptor(
    private val key: String
) : Interceptor, KoinComponent {

    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()

        val url = request.url.newBuilder()
            .addQueryParameter(API_KEY, key)
            .build()

        val interceptedRequest = request.newBuilder()
            .url(url)
            .build()

        return chain.proceed(interceptedRequest)
    }

    companion object {

        const val API_KEY = "api_key"
    }
}