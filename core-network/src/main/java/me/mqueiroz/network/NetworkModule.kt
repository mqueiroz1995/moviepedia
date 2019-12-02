package me.mqueiroz.network

import okhttp3.OkHttpClient
import org.koin.core.context.loadKoinModules
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.moshi.MoshiConverterFactory

object NetworkModule {

    private val module = module {

        single { ApiKeyHeaderInterceptor(get<ApiInfoProvider>().getKey()) }

        single { ServerConfigHeaderInterceptor() }

        single {
            val apiKeyInterceptor = get<ApiKeyHeaderInterceptor>()
            val serverConfigInterceptor = get<ServerConfigHeaderInterceptor>()

            OkHttpClient.Builder()
                .addInterceptor(apiKeyInterceptor)
                .addInterceptor(serverConfigInterceptor)
                .build()
        }

        single {
            val apiInfoProvider = get<ApiInfoProvider>()

            // TODO: inject wrapper instead of retrofit
            Retrofit.Builder()
                .baseUrl(apiInfoProvider.getHost())
                .client(get())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(MoshiConverterFactory.create())
                .build()
        }
    }

    fun load() = loadKoinModules(module)
}
