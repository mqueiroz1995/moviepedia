package me.mqueiroz.moviepedia

import me.mqueiroz.core_network.moduleCoreNetwork
import me.mqueiroz.home.di.moduleFeatureHome
import org.koin.core.module.Module

object KoinModulesProvider {

    fun getModules(): List<Module> = listOf(
        moduleApiInfo,
        moduleCoreNetwork,
        moduleFeatureHome
    )
}