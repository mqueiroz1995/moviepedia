package me.mqueiroz.network.serverconfig.domain

import io.reactivex.Single

interface ServerConfigRepository {

    fun getServerConfig(): Single<ServerConfig>

    fun getSupportedLanguages(): Single<List<Language>>
}