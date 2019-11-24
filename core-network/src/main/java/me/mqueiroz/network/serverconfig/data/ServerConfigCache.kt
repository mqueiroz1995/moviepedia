package me.mqueiroz.network.serverconfig.data

import io.reactivex.Single
import me.mqueiroz.network.serverconfig.domain.ServerConfig

internal interface ServerConfigCache {

    class CacheMissException : Exception()

    fun get(): Single<ServerConfig>

    fun save(config: ServerConfig)
}