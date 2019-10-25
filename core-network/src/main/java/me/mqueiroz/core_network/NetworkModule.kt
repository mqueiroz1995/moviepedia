package me.mqueiroz.core_network

import okhttp3.OkHttpClient
import org.koin.core.context.loadKoinModules
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.moshi.MoshiConverterFactory

private val moduleCoreNetworking = module {

    single {
        val apiInfoProvider = get<ApiInfoProvider>()

        OkHttpClient.Builder()
            .addInterceptor(GlobalParamsInterceptor(apiInfoProvider.getKey()))
            .build()
    }

    single {
        val apiInfoProvider = get<ApiInfoProvider>()

        Retrofit.Builder()
            .baseUrl(apiInfoProvider.getHost())
            .client(get())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(MoshiConverterFactory.create())
            .build()
    }
}

fun loadCoreNetwork() = loadKoinModules(moduleCoreNetworking)


