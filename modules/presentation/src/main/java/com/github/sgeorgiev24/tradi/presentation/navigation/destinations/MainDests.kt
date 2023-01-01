package com.github.sgeorgiev24.tradi.presentation.navigation.destinations

import androidx.navigation.NavOptions
import com.github.sgeorgiev24.tradi.presentation.navigation.NavAnimation
import com.github.sgeorgiev24.tradi.presentation.navigation.NavigationAction

sealed class MainDests : NavigationAction {
    object Home : AuthDests() {
        override val route: String
            get() = "home"
        override val navOptions: NavOptions
            get() = NavOptions.Builder()
                .setPopUpTo(0, true)
                .setLaunchSingleTop(true)
                .setRestoreState(true)
                .build()
        override val navAnimation: NavAnimation
            get() = NavAnimation.horizontalSlide()
    }

    object Analytics : AuthDests() {
        override val route: String
            get() = "analytics"
        override val navOptions: NavOptions
            get() = NavOptions.Builder()
                .setPopUpTo(0, true)
                .setLaunchSingleTop(true)
                .setRestoreState(true)
                .build()
        override val navAnimation: NavAnimation
            get() = NavAnimation.horizontalSlide()
    }

    object Settings : AuthDests() {
        override val route: String
            get() = "settings"
        override val navOptions: NavOptions
            get() = NavOptions.Builder()
                .setPopUpTo(0, true)
                .setLaunchSingleTop(true)
                .setRestoreState(true)
                .build()
        override val navAnimation: NavAnimation
            get() = NavAnimation.horizontalSlide()
    }
}
