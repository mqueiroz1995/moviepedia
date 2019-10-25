package me.mqueiroz.core_presentation

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer

inline fun <reified S : UIState, reified A : UIAction> LifecycleOwner.onStateChange(
    viewModel: ViewModel<S, A>,
    crossinline handleStates: (S) -> Unit
) {
    viewModel.state.observe(this, Observer { state -> handleStates(state as S) })
}

inline fun <reified S : UIState, reified A : UIAction> LifecycleOwner.onEvents(
    viewModel: ViewModel<S, A>,
    crossinline handleEvents: (S) -> Unit
) {
    viewModel.action.observe(this, Observer { event -> handleEvents(event as S) })
}