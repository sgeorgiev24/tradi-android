package com.github.sgeorgiev24.tradi.presentation.navigation.destinations

import com.github.sgeorgiev24.tradi.presentation.navigation.NavAnimation
import com.github.sgeorgiev24.tradi.presentation.navigation.NavigationAction

sealed class AuthDests : NavigationAction {
    object SignIn : AuthDests() {
        override val route: String
            get() = "signIn"
        override val navAnimation: NavAnimation
            get() = NavAnimation.horizontalSlide()
    }

    object SignUp : AuthDests() {
        override val route: String
            get() = "signUp"
        override val navAnimation: NavAnimation
            get() = NavAnimation.horizontalSlide()
    }

    object Loading : AuthDests() {
        override val route: String
            get() = "loading"
        override val navAnimation: NavAnimation
            get() = NavAnimation.horizontalSlide()
    }
}
