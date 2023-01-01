package com.github.sgeorgiev24.tradi.presentation.common.components.bottombar.mvi

import com.github.sgeorgiev24.tradi.presentation.navigation.NavigationAction

sealed class BottomNavigationAction {
    data class OnBottomNavItemClick(val navAction: NavigationAction) : BottomNavigationAction()
}
