package me.mqueiroz.moviepedia

import android.app.Application
import me.mqueiroz.core_network.moduleCoreNetwork
import me.mqueiroz.home.di.moduleFeatureHome
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.KoinAppDeclaration

object KoinApplicationProvider {

    fun get(application: Application): KoinAppDeclaration = {
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