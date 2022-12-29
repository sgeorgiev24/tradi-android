package com.github.sgeorgiev24.tradi.preview

import androidx.compose.runtime.Composable
import com.github.sgeorgiev24.tradi.model.settings.Theme
import com.github.sgeorgiev24.tradi.theme.TradiTheme

@Composable
fun PreviewComposable(
    theme: Theme = Theme.LIGHT,
    content: @Composable () -> Unit = {}
) {
    TradiTheme(theme) {
        content()
    }
}