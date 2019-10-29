package me.mqueiroz.moviepedia

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MainApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        loadKoin()
    }

    private fun loadKoin() {
        startKoin {
            androidContext(this@MainApplication)

            KoinModulesProvider.getModules()
        }
    }
}