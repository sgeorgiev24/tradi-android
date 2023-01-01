package com.github.sgeorgiev24.tradi.presentation.common.components.bottombar

import androidx.annotation.StringRes
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.github.sgeorgiev24.tradi.theme.TradiTheme

@Composable
fun BottomBarLabel(
    @StringRes labelRes: Int,
    isSelected: Boolean
) {
    Text(
        text = stringResource(labelRes),
        style = if (isSelected) TradiTheme.typography.smallBold else TradiTheme.typography.small,
//        color = if (isSelected) OtmTheme.colors.otmSelectedBottomNavItemColor
//        else OtmTheme.colors.otmBottomNavItemColor,
        maxLines = 1
    )
}