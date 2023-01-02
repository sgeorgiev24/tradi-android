package com.github.sgeorgiev24.tradi.presentation.view.home.mvi

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.viewModelScope
import com.github.sgeorgiev24.tradi.interactor.user.GetTmpUser
import com.github.sgeorgiev24.tradi.interactor.user.UserStateEvent
import com.github.sgeorgiev24.tradi.presentation.common.BaseViewModel
import com.github.sgeorgiev24.tradi.presentation.navigation.NavigationDispatcher
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel
@Inject
constructor(
    savedStateHandle: SavedStateHandle,
    private val navigationDispatcher: NavigationDispatcher,
    private val getTmpUser: GetTmpUser
) : BaseViewModel<HomeState, HomeAction, Unit>(
    savedStateHandle, HomeState()
) {

    init {
        viewModelScope.launch {
            getTmpUser()
        }
    }

    override suspend fun handleActions(action: HomeAction) {
        when (action) {
            HomeAction.OnAddExpenseClick -> {}
            HomeAction.OnAddIncomeClick -> {}
        }
    }

    private suspend fun getTmpUser() {
        getTmpUser(UserStateEvent.GetTmpUser).also { dataState ->
            dataState.data?.let {
                updateState {
                    this.copy(userName = it.name)
                }
            }
        }
    }
}