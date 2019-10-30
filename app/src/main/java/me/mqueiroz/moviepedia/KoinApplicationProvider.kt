package me.mqueiroz.moviepedia

import android.app.Application
import me.mqueiroz.core_network.moduleCoreNetwork
import me.mqueiroz.home.di.moduleFeatureHome
import org.koin.android.ext.koin.androidContext
import org.koin.core.KoinApplication
import org.koin.dsl.koinApplication

object KoinApplicationProvider {

    fun getKoinApplication(application: Application): KoinApplication = koinApplication {
        androidContext(application)

        modules(
            listOf(
                moduleApiInfo,
                moduleCoreNetwork,
                moduleFeatureHome
            )
        )
    }
}