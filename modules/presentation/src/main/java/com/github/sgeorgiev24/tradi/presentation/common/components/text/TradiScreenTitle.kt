package com.github.sgeorgiev24.tradi.presentation.common.components.text

import androidx.annotation.StringRes
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.github.sgeorgiev24.tradi.theme.Typographs

@Composable
fun TradiScreenTitle(
    @StringRes textResId: Int
) {
    Text(
        text = stringResource(id = textResId),
        style = Typographs.displayLarge
    )
}