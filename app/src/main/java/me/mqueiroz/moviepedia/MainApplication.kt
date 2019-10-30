package me.mqueiroz.moviepedia

import android.app.Application
import org.koin.core.context.startKoin

class MainApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        loadKoin()
    }

    private fun loadKoin() {
        startKoin {
            KoinApplicationProvider.getKoinApplication(this@MainApplication)
        }
    }
}