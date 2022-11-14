package com.coffetion.design_system.atoms

import androidx.compose.foundation.BorderStroke
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import com.coffetion.design_system.theme.CoffetionTheme
import com.coffetion.design_system.theme.contentColorFor

@Composable
fun Card(
    modifier: Modifier = Modifier,
    shape: Shape = CoffetionTheme.shapes.large,
    border: BorderStroke? = null,
    backgroundColor: Color = CoffetionTheme.colors.primary,
    contentColor: Color = contentColorFor(backgroundColor),
    content: @Composable () -> Unit
) {
    Surface(
        modifier = modifier,
        shape = shape,
        border = border,
        color = backgroundColor,
        contentColor = contentColor,
        content = content
    )
}

@Composable
fun Card(
    modifier: Modifier,
    onClick: () -> Unit,
    enabled: Boolean = true,
    shape: Shape = CoffetionTheme.shapes.large,
    border: BorderStroke? = null,
    backgroundColor: Color = CoffetionTheme.colors.primary,
    contentColor: Color = contentColorFor(backgroundColor),
    content: @Composable () -> Unit
) {
    Surface(
        modifier = modifier,
        onClick = onClick,
        enabled = enabled,
        shape = shape,
        border = border,
        color = backgroundColor,
        contentColor = contentColor,
        content = content
    )
}