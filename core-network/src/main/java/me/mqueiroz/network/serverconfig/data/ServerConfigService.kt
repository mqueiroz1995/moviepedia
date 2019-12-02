package me.mqueiroz.network.serverconfig.data

import io.reactivex.Single
import me.mqueiroz.network.serverconfig.domain.ServerConfig
import retrofit2.http.GET
import retrofit2.http.Headers

internal interface ServerConfigService {

    @Headers(SERVER_CONFIG_REQUEST_HEADER)
    @GET("configuration")
    fun getServerConfig(): Single<ServerConfig>

    @Headers(SERVER_CONFIG_REQUEST_HEADER)
    @GET("configuration/languages")
    fun getSupportedLanguages(): Single<List<Language>>

    companion object {

        const val SERVER_CONFIG_REQUEST = "SERVER_CONFIG_REQUEST_HEADER"
        const val SERVER_CONFIG_REQUEST_HEADER = "$SERVER_CONFIG_REQUEST: true"
    }
}