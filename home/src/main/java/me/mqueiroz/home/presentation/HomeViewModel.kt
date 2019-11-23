package me.mqueiroz.home.presentation

import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.rxkotlin.subscribeBy
import io.reactivex.schedulers.Schedulers
import me.mqueiroz.core_presentation.arch.ViewModel
import me.mqueiroz.home.data.MediaType
import me.mqueiroz.home.data.TimeWindow
import me.mqueiroz.home.data.TrendingRepository

class HomeViewModel(
    repository: TrendingRepository
) : ViewModel<HomeViewState, HomeViewAction>(initialState = HomeViewState()) {

    init {
        repository.getTrending(MediaType.TV, TimeWindow.DAY)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnSubscribe {
                setState { HomeViewState(isProgressBarVisible = true) }
            }
            .subscribeBy(
                onSuccess = {
                    val movies = it.results?.map { movie -> MovieListItemState(movie.name.orEmpty()) } ?: emptyList()

                    setState { HomeViewState(isListVisible = true, listItems = movies) }
                    sendAction { HomeViewAction.Success }
                },
                onError = {
                    setState { HomeViewState(isError = true) }
                    sendAction { HomeViewAction.Error }
                }
            )
            .handleDisposable()
    }
}