package com.github.sgeorgiev24.tradi.presentation.view.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.github.sgeorgiev24.tradi.presentation.R
import com.github.sgeorgiev24.tradi.presentation.common.components.container.TradiScreenContainer
import com.github.sgeorgiev24.tradi.presentation.common.components.text.TradiScreenSubtitle
import com.github.sgeorgiev24.tradi.presentation.common.components.text.TradiScreenTitle
import com.github.sgeorgiev24.tradi.presentation.common.components.util.TradiSpacer
import com.github.sgeorgiev24.tradi.presentation.view.home.mvi.HomeAction
import com.github.sgeorgiev24.tradi.presentation.view.home.mvi.HomeState
import com.github.sgeorgiev24.tradi.preview.DevicePreview
import com.github.sgeorgiev24.tradi.theme.Dimens
import com.github.sgeorgiev24.tradi.theme.Dimensions

@Composable
fun HomeContent(
    state: HomeState,
    action: (HomeAction) -> Unit
) {
    TradiScreenContainer(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
        ) {
            Title(state = state)

            OverviewCard()
        }
    }
}

@Composable
private fun Title(
    state: HomeState
) {
    state.userName?.let { name ->
        TradiScreenTitle(text = stringResource(id = R.string.home_title, name))
        TradiSpacer(height = Dimens.padding_huge)
    }
}

@Composable
private fun OverviewCard() {
    Card(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Column(
            modifier = Modifier
                .padding(start = Dimens.padding_horizontal)
        ) {
            TradiSpacer()
            TradiScreenSubtitle(
                modifier = Modifier.fillMaxWidth(),
                textResId = R.string.home_overview
            )
            TradiSpacer(height = Dimens.padding_medium)

            Text(
                text = "Your income is $1914"
            )
            TradiSpacer(height = Dimens.padding_small)

            Text(
                text = "You spent $19.14"
            )
            TradiSpacer()
        }
    }
}

@DevicePreview
@Composable
fun HomeScreenPreview() {
    HomeContent(state = HomeState(), action = {})
}