package me.mqueiroz.network.serverconfig.data

import io.reactivex.Single
import me.mqueiroz.network.serverconfig.domain.ServerConfig

// TODO: improve cache policy
internal class ServerConfigCacheImpl : ServerConfigCache {

    private var config: ServerConfig? = null

    override fun get(): Single<ServerConfig> {
        config?.let {
            return Single.just(config)
        }

        return Single.error(ServerConfigCache.CacheMissException())
    }

    override fun save(config: ServerConfig) {
        this.config = config
    }
}