package me.mqueiroz.network.serverconfig.data

import io.reactivex.Single
import me.mqueiroz.network.serverconfig.domain.ServerConfig
import me.mqueiroz.network.serverconfig.domain.ServerConfigRepository

internal class ServerConfigRepositoryImpl(
    private val cache: ServerConfigCache,
    private val service: ServerConfigService
) : ServerConfigRepository {

    override fun getServerConfig(): Single<ServerConfig> {
        return cache.get()
            .onErrorResumeNext {
                service.getServerConfig()
                    .doOnSuccess { cache.save(it) }
            }
    }
}