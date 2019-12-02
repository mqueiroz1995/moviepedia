package me.mqueiroz.home.di

import me.mqueiroz.home.data.MoviesRepositoryImpl
import me.mqueiroz.home.data.MovieService
import me.mqueiroz.home.domain.MoviesRepository
import me.mqueiroz.home.presentation.HomeFragment
import me.mqueiroz.home.presentation.HomeViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.context.loadKoinModules
import org.koin.dsl.module
import retrofit2.Retrofit

object HomeModule {

    private val module = module {
        single { get<Retrofit>().create(MovieService::class.java) }
        factory { MoviesRepositoryImpl(get(), get()) as MoviesRepository }

        viewModel { HomeViewModel(get()) }

        factory { HomeFragment(get()) }
    }

    fun load() = loadKoinModules(module)
}