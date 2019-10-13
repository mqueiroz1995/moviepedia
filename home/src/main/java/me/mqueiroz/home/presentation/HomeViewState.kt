package me.mqueiroz.home.presentation

sealed class HomeViewState {
    object Loading : HomeViewState()

    data class Success(
        val elements: List<String> = listOf(
            "a",
            "b",
            "c"
        )
    ) : HomeViewState()

    object Error : HomeViewState()
}