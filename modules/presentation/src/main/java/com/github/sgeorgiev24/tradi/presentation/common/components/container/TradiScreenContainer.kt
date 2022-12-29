package com.github.sgeorgiev24.tradi.presentation.common.components.container

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.github.sgeorgiev24.tradi.theme.Dimens

@Composable
fun TradiScreenContainer(
    modifier: Modifier = Modifier,
    verticalArrangement: Arrangement.Vertical = Arrangement.Top,
    horizontalAlignment: Alignment.Horizontal = Alignment.Start,
    content: @Composable () -> Unit
) {
    Column(
        modifier = modifier
            .padding(
                horizontal = Dimens.padding_horizontal,
                vertical = Dimens.padding_vertical
            ),
        horizontalAlignment = horizontalAlignment,
        verticalArrangement = verticalArrangement
    ) {
        content()
    }
}