package com.coffetion.design_system.theme

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.ReadOnlyComposable

@Composable
fun CoffetionTheme(
    colors: CoffetionColors,
    typography: CoffetionTypography,
    shapes: CoffetionShapes,
    content: @Composable () -> Unit
) {
    CompositionLocalProvider(
        LocalColors provides colors,
        LocalTypography provides typography,
        LocalShapes provides shapes
    ) {
        content()
    }
}

object CoffetionTheme {
    val colors: CoffetionColors
        @Composable
        @ReadOnlyComposable
        get() = LocalColors.current

    val typography: CoffetionTypography
        @Composable
        @ReadOnlyComposable
        get() = LocalTypography.current

    val shapes: CoffetionShapes
        @Composable
        @ReadOnlyComposable
        get() = LocalShapes.current
}