package me.mqueiroz.moviepedia

import android.app.Application
import me.mqueiroz.core_network.NetworkModule
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
        HomeModule.load()
    }
}