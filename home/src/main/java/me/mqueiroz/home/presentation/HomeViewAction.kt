package me.mqueiroz.home.presentation

import me.mqueiroz.core_presentation.UIAction

sealed class HomeViewAction : UIAction {

    object Success : HomeViewAction()

    object Error : HomeViewAction()
}