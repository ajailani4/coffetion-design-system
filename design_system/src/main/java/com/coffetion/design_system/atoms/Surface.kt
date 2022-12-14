package com.coffetion.design_system.atoms

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.semantics.SemanticsModifier
import androidx.compose.ui.semantics.semantics
import com.coffetion.design_system.theme.CoffetionTheme
import com.coffetion.design_system.theme.LocalContentColor
import com.coffetion.design_system.theme.contentColorFor

@Composable
fun Surface(
    modifier: Modifier = Modifier,
    shape: Shape = RectangleShape,
    border: BorderStroke? = null,
    color: Color = CoffetionTheme.colors.white,
    contentColor: Color = contentColorFor(color),
    clickAndSemanticsModifier: Modifier,
    content: @Composable () -> Unit
) {
    CompositionLocalProvider(
        LocalContentColor provides contentColor
    ) {
        Box(
            modifier = modifier
                .then(if (border != null) Modifier.border(border, shape) else Modifier)
                .background(
                    color = color,
                    shape = shape
                )
                .clip(shape)
                .then(clickAndSemanticsModifier),
            propagateMinConstraints = true
        ) {
            content()
        }
    }
}

@Composable
fun Surface(
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
    enabled: Boolean = true,
    shape: Shape = RectangleShape,
    border: BorderStroke? = null,
    color: Color = CoffetionTheme.colors.white,
    contentColor: Color = contentColorFor(color),
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
    content: @Composable () -> Unit
) {
    Surface(
        modifier = modifier,
        shape = shape,
        border = border,
        color = color,
        contentColor = contentColor,
        clickAndSemanticsModifier = Modifier.clickable(
            interactionSource = interactionSource,
            indication = null,
            enabled = enabled,
            role = Role.Button,
            onClick = onClick
        ),
        content = content
    )
}

@Composable
fun Surface(
    modifier: Modifier = Modifier,
    shape: Shape = RectangleShape,
    border: BorderStroke? = null,
    color: Color = CoffetionTheme.colors.white,
    contentColor: Color = contentColorFor(color),
    content: @Composable () -> Unit
) {
    Surface(
        modifier = modifier,
        shape = shape,
        border = border,
        color = color,
        contentColor = contentColor,
        clickAndSemanticsModifier = Modifier
            .semantics(mergeDescendants = false) {}
            .pointerInput(Unit) {},
        content = content
    )
}