package com.coffetion.design_system.theme

import androidx.compose.runtime.*
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.takeOrElse

@Stable
class CoffetionColors(
    primary: Color,
    secondary: Color,
    optional: Color,
    info: Color,
    success: Color,
    error: Color,
    white: Color,
    black: Color
) {
    var primary by mutableStateOf(primary)
        internal set
    var secondary by mutableStateOf(secondary)
        internal set
    var optional by mutableStateOf(optional)
        internal set
    var info by mutableStateOf(info)
        internal set
    var success by mutableStateOf(success)
        internal set
    var error by mutableStateOf(error)
        internal set
    var white by mutableStateOf(white)
        internal set
    var black by mutableStateOf(black)
        internal set
}

fun lightColors(
    primary: Color = Color(0xFF650AB9),
    secondary: Color = Color(0xFFF7B149),
    optional: Color = Color(0xFF0A9A5B),
    info: Color = Color(0xFF1B87A6),
    success: Color = Color(0xFF29AF1C),
    error: Color = Color(0xFFB21F1F),
    white: Color = Color(0xFFF8F8F8),
    black: Color = Color(0xFF2A2A2A)
): CoffetionColors = CoffetionColors(
    primary,
    secondary,
    optional,
    info,
    success,
    error,
    white,
    black
)

fun CoffetionColors.contentColorFor(backgroundColor: Color): Color {
    return when (backgroundColor) {
        primary -> white
        secondary -> black
        optional -> white
        info -> white
        success -> white
        error -> white
        white -> black
        black -> white
        else -> Color.Unspecified
    }
}

@Composable
@ReadOnlyComposable
fun contentColorFor(backgroundColor: Color) =
    CoffetionTheme.colors.contentColorFor(backgroundColor).takeOrElse { LocalContentColor.current }

internal val LocalColors = staticCompositionLocalOf { lightColors() }
internal val LocalContentColor = compositionLocalOf { Color.Black }