package me.mqueiroz.network.serverconfig.data

import io.reactivex.Single
import me.mqueiroz.network.serverconfig.domain.ServerConfig
import retrofit2.http.GET

internal interface ServerConfigService {

    @GET("configuration")
    fun getServerConfig(): Single<ServerConfig>
}