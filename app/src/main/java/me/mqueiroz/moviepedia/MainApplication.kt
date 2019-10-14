package me.mqueiroz.moviepedia

import android.app.Application
import me.mqueiroz.core_network.loadCoreNetwork
import me.mqueiroz.home.di.loadFeatureHome
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MainApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        loadKoin()
    }

    private fun loadKoin() {
        startKoin { androidContext(this@MainApplication) }
        loadCoreModules()
        loadFeatureModules()
    }

    private fun loadCoreModules() {
        loadApiInfoProvider()
        loadCoreNetwork()
    }

    private fun loadFeatureModules() {
        loadFeatureHome()
    }
}