package me.mqueiroz.moviepedia

import me.mqueiroz.core_network.ApiInfoProvider
import org.koin.dsl.module

val moduleApiInfo = module {
    single<ApiInfoProvider> {
        object : ApiInfoProvider {
            override fun getHost(): String = BuildConfig.API_HOST

            override fun getKey(): String = BuildConfig.API_KEY
        }
    }
}