package me.mqueiroz.network

import me.mqueiroz.network.serverconfig.data.ServerConfigService.Companion.SERVER_CONFIG_REQUEST
import me.mqueiroz.network.serverconfig.domain.GetLanguageUseCase
import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response
import org.koin.core.KoinComponent
import org.koin.core.inject

class ServerConfigHeaderInterceptor : Interceptor, KoinComponent {

    // This OkHttp interceptor has a dependency on Retrofit
    // because it needs to fetch data from server to work.
    // This would create a circular dependency on koin DAG
    // and that's way this field is lazy initialized.
    private val getUserLanguage: GetLanguageUseCase by inject()

    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()

        if (isServerConfigRequest(request)) {
            redactReaders(request)
            return chain.proceed(request)
        }

        val url = request.url.newBuilder()
            .addQueryParameter(LANGUAGE, getLanguage())
            .build()

        val interceptedRequest = request.newBuilder()
            .url(url)
            .build()

        return chain.proceed(interceptedRequest)
    }

    private fun isServerConfigRequest(request: Request): Boolean {
        return request.headers.names().contains(SERVER_CONFIG_REQUEST)
    }

    private fun redactReaders(request: Request) {
        request.headers.filter { header ->
            (header.first != SERVER_CONFIG_REQUEST)
        }
    }

    private fun getLanguage(): String {
        return getUserLanguage().blockingGet()
    }

    companion object {

        private const val LANGUAGE = "language"
    }
}