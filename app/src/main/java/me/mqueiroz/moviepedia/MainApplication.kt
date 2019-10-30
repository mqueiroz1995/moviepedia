package me.mqueiroz.moviepedia

import androidx.multidex.MultiDexApplication
import org.koin.core.context.startKoin

class MainApplication : MultiDexApplication() {

    override fun onCreate() {
        super.onCreate()

        loadKoin()
    }

    private fun loadKoin() {
        startKoin(KoinApplicationProvider.get(this@MainApplication))
    }
}