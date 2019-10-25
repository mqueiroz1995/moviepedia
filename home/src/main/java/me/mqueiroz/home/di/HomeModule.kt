package me.mqueiroz.home.di

import me.mqueiroz.home.data.TrendingRepository
import me.mqueiroz.home.data.TrendingService
import me.mqueiroz.home.presentation.HomeViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.context.loadKoinModules
import org.koin.dsl.module
import retrofit2.Retrofit

private val moduleFeatureHome = module {
    single { get<Retrofit>().create(TrendingService::class.java) }
    factory { TrendingRepository(get()) }

    viewModel { HomeViewModel(get()) }
}

fun loadFeatureHome() = loadKoinModules(moduleFeatureHome)