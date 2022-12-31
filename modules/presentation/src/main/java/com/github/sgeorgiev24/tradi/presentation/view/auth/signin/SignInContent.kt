package com.github.sgeorgiev24.tradi.presentation.view.auth.signin

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import com.github.sgeorgiev24.tradi.presentation.R
import com.github.sgeorgiev24.tradi.presentation.common.components.button.TradiButton
import com.github.sgeorgiev24.tradi.presentation.common.components.container.TradiScreenContainer
import com.github.sgeorgiev24.tradi.presentation.common.components.text.TradiScreenTitle
import com.github.sgeorgiev24.tradi.presentation.common.components.text.TradiTextLink
import com.github.sgeorgiev24.tradi.presentation.common.components.textfield.TradiOutlinedTextField
import com.github.sgeorgiev24.tradi.presentation.common.components.util.TradiSpacer
import com.github.sgeorgiev24.tradi.presentation.view.auth.signin.mvi.SignInAction
import com.github.sgeorgiev24.tradi.presentation.view.auth.signin.mvi.SignInState
import com.github.sgeorgiev24.tradi.theme.Dimens

@Composable
fun SignInContent(
    state: SignInState,
    action: (SignInAction) -> Unit
) {
    TradiScreenContainer(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center
    ) {
        Column(
            modifier = Modifier.wrapContentHeight()
        ) {
            TradiScreenTitle(textResId = R.string.sign_in_title)

            TradiTextLink(
                title = stringResource(R.string.sign_in_sign_up_link),
                onClick = { action(SignInAction.OnSignUpLinkClick) }
            )
            TradiSpacer(Dimens.padding_large)

            TradiOutlinedTextField(
                inputWrapper = state.email,
                label = stringResource(id = R.string.sign_in_email),
                keyboardActions = KeyboardActions(onNext = { action(SignInAction.OnNextActionClick) }),
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Email,
                    imeAction = ImeAction.Next,
                ),
                onTextChanged = { text, _ -> action(SignInAction.OnEmailValueChange(text)) },
            )
            TradiSpacer()

            TradiOutlinedTextField(
                inputWrapper = state.password,
                label = stringResource(id = R.string.sign_in_password),
                keyboardActions = KeyboardActions(onDone = { action(SignInAction.OnDoneActionClick) }),
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Password,
                    imeAction = ImeAction.Done,
                ),
                onTextChanged = { text, _ -> action(SignInAction.OnPasswordValueChange(text)) },
                visualTransformation = PasswordVisualTransformation()
            )
            TradiSpacer(Dimens.padding_large)

            TradiButton(
                enabled = state.isLoginButtonEnabled,
                titleResId = R.string.sign_in_sign_in_button,
                onClick = { action(SignInAction.OnSignInClick) }
            )
        }
    }
}