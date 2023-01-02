package com.github.sgeorgiev24.tradi.presentation.view.home.mvi

sealed class HomeAction {
    object OnAddIncomeClick : HomeAction()
    object OnAddExpenseClick : HomeAction()
}