package me.mqueiroz.home.di

import me.mqueiroz.home.data.GlobalParamsInterceptor
import okhttp3.OkHttpClient
import org.koin.core.context.loadKoinModules
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.moshi.MoshiConverterFactory

private const val url = "https://api.themoviedb.org/3/"

private val moduleCoreNetworking = module {

    single {
        OkHttpClient.Builder()
            .addInterceptor(GlobalParamsInterceptor())
            .build()
    }

    single {
        Retrofit.Builder()
            .baseUrl(url)
            .client(get())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(MoshiConverterFactory.create())
            .build()
    }
}

fun loadCoreNetwork() = loadKoinModules(moduleCoreNetworking)

