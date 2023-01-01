package com.github.sgeorgiev24.tradi.presentation.common.components.bottombar

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.github.sgeorgiev24.tradi.presentation.R
import com.github.sgeorgiev24.tradi.presentation.navigation.NavigationAction
import com.github.sgeorgiev24.tradi.presentation.navigation.destinations.MainDests

enum class BottomNavigationItem(
    val destination: NavigationAction,
    @StringRes val labelResId: Int,
    @DrawableRes val iconResId: Int
) {
    Home(
        destination = MainDests.Home,
        labelResId = R.string.bottom_bar_home,
        iconResId = R.drawable.ic_home
    ),
    Analytics(
        destination = MainDests.Analytics,
        labelResId = R.string.bottom_bar_analytics,
        iconResId = R.drawable.ic_analytics
    ),
    Settings(
        destination = MainDests.Settings,
        labelResId = R.string.bottom_bar_settings,
        iconResId = R.drawable.ic_settings
    )
}