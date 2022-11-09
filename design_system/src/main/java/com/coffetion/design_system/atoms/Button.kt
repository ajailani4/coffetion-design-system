package com.coffetion.design_system.atoms

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.dp
import com.coffetion.design_system.theme.CoffetionTheme

@Composable
fun Button(
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
    enabled: Boolean = true,
    shape: Shape = CoffetionTheme.shapes.medium,
    color: Color = CoffetionTheme.colors.primary,
    contentPadding: PaddingValues = PaddingValues(horizontal = 15.dp, vertical = 10.dp),
    content: @Composable RowScope.() -> Unit
) {
    Surface(
        modifier = modifier,
        onClick = onClick,
        enabled = enabled,
        shape = shape,
        color = color
    ) {
        ProvideTextStyle(style = CoffetionTheme.typography.title2) {
            Row(
                modifier = modifier.padding(contentPadding),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                content()
            }
        }
    }
}