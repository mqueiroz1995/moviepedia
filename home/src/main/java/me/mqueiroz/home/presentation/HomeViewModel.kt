package me.mqueiroz.home.presentation

import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.rxkotlin.subscribeBy
import io.reactivex.schedulers.Schedulers
import me.mqueiroz.core_presentation.ViewModel
import me.mqueiroz.home.data.MediaType
import me.mqueiroz.home.data.TimeWindow
import me.mqueiroz.home.data.TrendingRepository

class HomeViewModel(
    private val repository: TrendingRepository
) : ViewModel<HomeViewState, HomeViewAction>() {

    init {
        repository.getTrending(MediaType.TV, TimeWindow.DAY)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnSubscribe {
                setState { HomeViewState(isProgressBarVisible = true) }
            }
            .subscribeBy(
                onSuccess = { setState { HomeViewState(isListVisible = true, listItems = listOf("a", "b", "c")) } },
                onError = { setState { HomeViewState(isError = true) } }
            )
            .handleDisposable()
    }
}