package me.mqueiroz.network.serverconfig.di

import me.mqueiroz.network.serverconfig.data.ServerConfigCache
import me.mqueiroz.network.serverconfig.data.ServerConfigCacheImpl
import me.mqueiroz.network.serverconfig.data.ServerConfigRepositoryImpl
import me.mqueiroz.network.serverconfig.data.ServerConfigService
import me.mqueiroz.network.serverconfig.domain.ServerConfigRepository
import org.koin.core.context.loadKoinModules
import org.koin.dsl.module
import retrofit2.Retrofit

object ServerConfigModule {

    private val configurationModule = module {
        single { get<Retrofit>().create(ServerConfigService::class.java) }
        single { ServerConfigCacheImpl() as ServerConfigCache }

        single { ServerConfigRepositoryImpl(get(), get()) as ServerConfigRepository }
    }

    fun load() = loadKoinModules(configurationModule)
}