package me.mqueiroz.moviepedia

import me.mqueiroz.network.ApiInfoProvider
import org.koin.core.context.loadKoinModules
import org.koin.dsl.module

object ApiInfoModule {
    private val module = module {
        single<ApiInfoProvider> {
            object : ApiInfoProvider {
                override fun getHost(): String = BuildConfig.API_HOST

                override fun getKey(): String = BuildConfig.API_KEY
            }
        }
    }

    fun load() = loadKoinModules(module)
}
