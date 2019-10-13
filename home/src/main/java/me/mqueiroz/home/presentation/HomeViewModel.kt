package me.mqueiroz.home.presentation

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.addTo
import io.reactivex.rxkotlin.subscribeBy
import io.reactivex.schedulers.Schedulers
import me.mqueiroz.home.SingleLiveEvent
import me.mqueiroz.home.data.MediaType
import me.mqueiroz.home.data.TimeWindow
import me.mqueiroz.home.data.TrendingRepository

class HomeViewModel(
    private val repository: TrendingRepository
) : ViewModel() {

    private val disposable = CompositeDisposable()

    private val _state = MutableLiveData<HomeViewState>()
    val state: LiveData<HomeViewState> = _state

    private val _command = SingleLiveEvent<HomeViewCommand>()
    val command: LiveData<HomeViewCommand> = _command

    init {
        repository.getTrending(MediaType.TV, TimeWindow.DAY)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnSubscribe { _state.value = HomeViewState.Loading }
            .subscribeBy(
                onSuccess = { handleSuccess() },
                onError = { handleError() }
            )
            .addTo(disposable)
    }

    private fun handleSuccess() {
        _state.value = HomeViewState.Success()
    }

    private fun handleError() {
        _state.value = HomeViewState.Error
    }

    override fun onCleared() {
        disposable.dispose()
        super.onCleared()
    }
}