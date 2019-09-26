package me.mqueiroz.home

import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.context.loadKoinModules
import org.koin.dsl.module
import retrofit2.Retrofit


private val moduleFeatureHome = module {

    single { get<Retrofit>().create(TMDBService::class.java) }

    viewModel { HomeViewModel(get()) }
}

fun loadFeatureHome() = loadKoinModules(moduleFeatureHome)