package me.mqueiroz.core_presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

abstract class ViewModel<State : UIState, T : UIAction> : androidx.lifecycle.ViewModel() {

    private val disposable = CompositeDisposable()

    private val _state = MutableLiveData<State>()
    val state: LiveData<State> = _state

    private val _action = SingleLiveEvent<T>()
    val action: LiveData<T> = _action

    protected fun Disposable.handleDisposable(): Disposable =
        apply { disposable.add(this) }

    protected fun setState(state: () -> State) {
        _state.value = state()
    }

    protected fun sendEvent(action: () -> T) {
        _action.value = action()
    }

    override fun onCleared() {
        disposable.dispose()
        super.onCleared()
    }
}