package me.mqueiroz.network.serverconfig.domain

import io.reactivex.Single
import me.mqueiroz.network.serverconfig.domain.ServerConfig

interface ServerConfigRepository {

    fun getServerConfig() : Single<ServerConfig>
}