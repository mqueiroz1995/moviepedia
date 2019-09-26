package me.mqueiroz.home

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.addTo
import io.reactivex.rxkotlin.subscribeBy
import io.reactivex.schedulers.Schedulers

class HomeViewModel(
    private val service: TMDBService
) : ViewModel() {

    private val disposable = CompositeDisposable()

    private val _text = MutableLiveData<String>("LIVEDATA STRING")
    val text: LiveData<String> = _text

    init {

        service.trending()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeBy(
                onSuccess = { Log.d("test", "success") },
                onError = { Log.d("test", "success") }
            )
            .addTo(disposable)
    }

    override fun onCleared() {
        disposable.dispose()
        super.onCleared()
    }
}