package me.mqueiroz.home.presentation

import me.mqueiroz.core_presentation.arch.UIState

data class HomeViewState(
    val isProgressBarVisible: Boolean = false,
    val isError: Boolean = false,
    val isListVisible: Boolean = false,
    val listItems: List<MovieListItemState> = emptyList()
) : UIState {

    companion object {
        val initialState
            get() = HomeViewState()
    }
}

