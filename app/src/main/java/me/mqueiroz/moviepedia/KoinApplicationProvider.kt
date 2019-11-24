package me.mqueiroz.moviepedia

import android.app.Application
import me.mqueiroz.network.NetworkModule
import me.mqueiroz.network.serverconfig.di.ServerConfigModule
import me.mqueiroz.home.di.HomeModule
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.fragment.koin.fragmentFactory
import org.koin.dsl.KoinAppDeclaration

object KoinApplicationProvider {

    fun get(application: Application): KoinAppDeclaration = {
        androidContext(application)
        fragmentFactory()

        ApiInfoModule.load()
        NetworkModule.load()
        ServerConfigModule.load()
        HomeModule.load()
    }
}