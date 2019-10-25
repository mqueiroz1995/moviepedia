package me.mqueiroz.moviepedia

import me.mqueiroz.core_network.ApiInfoProvider
import org.koin.core.context.loadKoinModules
import org.koin.dsl.module

fun loadApiInfoProvider() = loadKoinModules(module {
    single<ApiInfoProvider> {
        object : ApiInfoProvider {
            override fun getHost(): String = BuildConfig.API_HOST

            override fun getKey(): String = BuildConfig.API_KEY
        }
    }
})