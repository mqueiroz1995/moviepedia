package me.mqueiroz.home.di

import me.mqueiroz.home.data.TrendingRepositoryImpl
import me.mqueiroz.home.data.TrendingService
import me.mqueiroz.home.domain.TrendingRepository
import me.mqueiroz.home.presentation.HomeFragment
import me.mqueiroz.home.presentation.HomeViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.context.loadKoinModules
import org.koin.dsl.module
import retrofit2.Retrofit

object HomeModule {

    private val module = module {
        single { get<Retrofit>().create(TrendingService::class.java) }
        factory { TrendingRepositoryImpl(get(), get()) as TrendingRepository }

        viewModel { HomeViewModel(get()) }

        factory { HomeFragment(get()) }
    }

    fun load() = loadKoinModules(module)
}