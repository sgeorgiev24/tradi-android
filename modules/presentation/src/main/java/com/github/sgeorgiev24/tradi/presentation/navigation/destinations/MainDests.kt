package com.github.sgeorgiev24.tradi.presentation.navigation.destinations

import com.github.sgeorgiev24.tradi.presentation.navigation.NavAnimation
import com.github.sgeorgiev24.tradi.presentation.navigation.NavigationAction

sealed class MainDests : NavigationAction {
    object Home : AuthDests() {
        override val route: String
            get() = "home"
        override val navAnimation: NavAnimation
            get() = NavAnimation.horizontalSlide()
    }
}
