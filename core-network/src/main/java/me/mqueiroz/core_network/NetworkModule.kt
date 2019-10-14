package me.mqueiroz.core_network

import okhttp3.OkHttpClient
import org.koin.core.context.loadKoinModules
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.moshi.MoshiConverterFactory

private var url = "https://api.themoviedb.org/3/"
private var key = ""

private val moduleCoreNetworking = module {
    single {
        OkHttpClient.Builder()
            .addInterceptor(GlobalParamsInterceptor(get<ApiInfoProvider>().provideKey()))
            .build()
    }

    single {
        Retrofit.Builder()
            .baseUrl(get<ApiInfoProvider>().provideHost())
            .client(get())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(MoshiConverterFactory.create())
            .build()
    }
}

fun loadCoreNetwork() = loadKoinModules(moduleCoreNetworking)


