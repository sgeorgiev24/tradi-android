package com.github.sgeorgiev24.tradi.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.ColorScheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.*
import androidx.compose.ui.platform.LocalConfiguration
import com.github.sgeorgiev24.tradi.model.settings.Theme
import com.google.accompanist.systemuicontroller.rememberSystemUiController

@Composable
fun ProvideAppColors(
    colors: ColorScheme,
    content: @Composable () -> Unit
) {
    CompositionLocalProvider(LocalAppColors provides colors, content = content)
}

@Composable
fun ProvideDimens(
    dimensions: Dimensions,
    content: @Composable () -> Unit
) {
    CompositionLocalProvider(LocalAppDimens provides dimensions, content = content)
}

@Composable
fun ProvideTypography(
    typography: TradiTypography,
    content: @Composable () -> Unit
) {
    CompositionLocalProvider(LocalTypography provides typography, content = content)
}

@Composable
fun ProvideIsLightTheme(
    isLightTheme: Boolean,
    content: @Composable () -> Unit
) {
    CompositionLocalProvider(LocalIsLightTheme provides isLightTheme, content = content)
}

private val LocalAppDimens = staticCompositionLocalOf { smallDimensions }
private val LocalAppColors = staticCompositionLocalOf { getColors(true) }
private val LocalTypography = staticCompositionLocalOf { CustomTradiTypography as TradiTypography }
private val LocalIsLightTheme = staticCompositionLocalOf { true }

@Composable
fun TradiTheme(
    theme: Theme = Theme.LIGHT,
    content: @Composable () -> Unit
) {
    val isLightTheme = when (theme) {
        Theme.DARK -> false
        Theme.LIGHT -> true
        Theme.SYSTEM -> !isSystemInDarkTheme()
    }

    val tradiColors = getColors(isLightTheme)
    val tradiTypography = CustomTradiTypography

    val configuration = LocalConfiguration.current
    val dimensions = when {
        configuration.screenWidthDp <= 360 -> smallDimensions
        configuration.screenWidthDp in 361..600 -> sw360Dimensions
        configuration.screenWidthDp in 601..940 -> sw600Dimensions
        configuration.screenWidthDp > 940 -> sw940Dimensions
        else -> smallDimensions
    }

    ProvideDimens(dimensions = dimensions) {
        ProvideAppColors(colors = tradiColors) {
            ProvideTypography(typography = tradiTypography) {
                ProvideIsLightTheme(isLightTheme = isLightTheme) {
                    MaterialTheme(
                        colorScheme = getColors(isLightTheme),
                        typography = getTypography(tradiTypography),
                        content = content
                    )
                    UpdateSystemBarsColors(isLightTheme = isLightTheme, colors = tradiColors)
                }
            }
        }
    }
}

@Composable
fun UpdateSystemBarsColors(isLightTheme: Boolean, colors: ColorScheme) {
    val systemUiController = rememberSystemUiController()
    SideEffect {
        systemUiController.setSystemBarsColor(color = colors.primary, darkIcons = isLightTheme)
    }
}

object TradiTheme {
    val colors: ColorScheme
        @Composable
        get() = LocalAppColors.current

    val dimens: Dimensions
        @Composable
        get() = LocalAppDimens.current

    val typography: TradiTypography
        @Composable
        get() = LocalTypography.current

    val isLightTheme: Boolean
        @Composable
        get() = LocalIsLightTheme.current
}

val Dimens: Dimensions
    @Composable
    get() = TradiTheme.dimens

val Colors: ColorScheme
    @Composable
    get() = TradiTheme.colors

val Typographs: TradiTypography
    @Composable
    get() = TradiTheme.typography

val IsLightTheme: Boolean
    @Composable
    get() = TradiTheme.isLightTheme