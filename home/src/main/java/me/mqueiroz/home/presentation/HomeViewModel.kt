package me.mqueiroz.home.presentation

import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.rxkotlin.subscribeBy
import io.reactivex.schedulers.Schedulers
import me.mqueiroz.core_presentation.arch.ViewModel
import me.mqueiroz.home.data.MediaType
import me.mqueiroz.home.data.TimeWindow
import me.mqueiroz.home.domain.MoviesRepository

class HomeViewModel(
    repository: MoviesRepository
) : ViewModel<HomeViewState, HomeViewAction>(HomeViewState.initialState) {

    init {
        repository.getNowPlaying(MediaType.TV, TimeWindow.DAY)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnSubscribe { setState { HomeViewState(isProgressBarVisible = true) } }
            .map {
                it.map { movie ->
                    MovieListItemState(
                        poster = movie.poster,
                        name = movie.title,
                        rate = "${movie.rate}/10"
                    )
                }
            }
            .subscribeBy(
                onSuccess = { movies ->
                    setState { HomeViewState(isListVisible = true, listItems = movies) }
                },
                onError = {
                    setState { HomeViewState(isError = true) }
                }
            )
            .handleDisposable()
    }
}