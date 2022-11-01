package com.coffetion.design_system.atoms

import androidx.compose.foundation.text.BasicText
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.takeOrElse
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import com.coffetion.design_system.theme.CoffetionTheme
import com.coffetion.design_system.theme.LocalContentAlpha
import com.coffetion.design_system.theme.LocalContentColor

@Composable
fun Text(
    modifier: Modifier = Modifier,
    text: String,
    color: Color,
    style: TextStyle = CoffetionTheme.typography.body1,
    textAlign: TextAlign? = null
) {
    val textColor = color.takeOrElse {
        style.color.takeOrElse {
            LocalContentColor.current.copy(alpha = LocalContentAlpha.current)
        }
    }

    val mergedStyle = style.copy(color = textColor, textAlign = textAlign)

    BasicText(
        modifier = modifier,
        text = text,
        style = mergedStyle
    )
}

val LocalTextStyle = compositionLocalOf { TextStyle.Default }

@Composable
fun ProvideTextStyle(value: TextStyle, content: @Composable () -> Unit) {
    val mergedStyle = LocalTextStyle.current.merge(value)
    CompositionLocalProvider(
        LocalTextStyle provides mergedStyle,
        content = content
    )
}
