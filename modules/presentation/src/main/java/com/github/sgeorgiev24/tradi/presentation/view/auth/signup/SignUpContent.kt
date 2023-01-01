package com.github.sgeorgiev24.tradi.presentation.view.auth.signup

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
import com.github.sgeorgiev24.tradi.presentation.view.auth.signup.mvi.SignUpAction
import com.github.sgeorgiev24.tradi.presentation.view.auth.signup.mvi.SignUpState
import com.github.sgeorgiev24.tradi.theme.Dimens

@Composable
fun SignUpContent(
    state: SignUpState,
    action: (SignUpAction) -> Unit
) {
    TradiScreenContainer(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center
    ) {
        Column(
            modifier = Modifier.wrapContentHeight()
        ) {
            TradiScreenTitle(textResId = R.string.sign_up_title)

            TradiTextLink(
                title = stringResource(R.string.sign_up_sign_in_link),
                onClick = { action(SignUpAction.OnSignInLinkClick) }
            )
            TradiSpacer(Dimens.padding_large)

            TradiOutlinedTextField(
                inputWrapper = state.email,
                label = stringResource(id = R.string.sign_up_email),
                keyboardActions = KeyboardActions(onNext = { action(SignUpAction.OnNextActionClick) }),
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Email,
                    imeAction = ImeAction.Next,
                ),
                onTextChanged = { text, _ -> action(SignUpAction.OnEmailValueChange(text)) },
            )
            TradiSpacer()

            TradiOutlinedTextField(
                inputWrapper = state.name,
                label = stringResource(id = R.string.sign_up_name),
                keyboardActions = KeyboardActions(onNext = { action(SignUpAction.OnNextActionClick) }),
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Text,
                    imeAction = ImeAction.Next,
                ),
                onTextChanged = { text, _ -> action(SignUpAction.OnNameValueChange(text)) },
            )
            TradiSpacer()

            TradiOutlinedTextField(
                inputWrapper = state.password,
                label = stringResource(id = R.string.sign_up_password),
                keyboardActions = KeyboardActions(onNext = { action(SignUpAction.OnNextActionClick) }),
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Password,
                    imeAction = ImeAction.Next,
                ),
                onTextChanged = { text, _ -> action(SignUpAction.OnPasswordValueChange(text)) },
                visualTransformation = PasswordVisualTransformation()
            )
            TradiSpacer()

            TradiOutlinedTextField(
                inputWrapper = state.confirmPassword,
                label = stringResource(id = R.string.sign_up_confirm_password),
                keyboardActions = KeyboardActions(onDone = { action(SignUpAction.OnDoneActionClick) }),
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Password,
                    imeAction = ImeAction.Done,
                ),
                onTextChanged = { text, _ -> action(SignUpAction.OnConfirmPasswordValueChange(text)) },
                visualTransformation = PasswordVisualTransformation()
            )
            TradiSpacer(Dimens.padding_large)

            TradiButton(
                enabled = state.isRegisterButtonEnabled,
                titleResId = R.string.sign_up_sign_up_button,
                onClick = { action(SignUpAction.OnRegisterClick) }
            )
        }
    }
}