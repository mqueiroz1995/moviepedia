package me.mqueiroz.core_presentation

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer

inline fun <reified State : UIState, reified Action : UIAction> LifecycleOwner.onStateChange(
    viewModel: ViewModel<State, Action>,
    crossinline handleStates: (State) -> Unit
) {
    viewModel.state.observe(this, Observer { state -> handleStates(state as State) })
}

inline fun <reified State : UIState, reified Action : UIAction> LifecycleOwner.onAction(
    viewModel: ViewModel<State, Action>,
    crossinline handleEvents: (Action) -> Unit
) {
    viewModel.action.observe(this, Observer { event -> handleEvents(event as Action) })
}