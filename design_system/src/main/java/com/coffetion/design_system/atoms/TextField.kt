package com.coffetion.design_system.atoms

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import com.coffetion.design_system.theme.CoffetionTheme

private val minWidth = 70.dp
private val minHeight = 32.dp

@Composable
fun TextField(
    modifier: Modifier = Modifier,
    value: String,
    onValueChange: (String) -> Unit,
    enabled: Boolean = true,
    shape: Shape = CoffetionTheme.shapes.large,
    textStyle: TextStyle = CoffetionTheme.typography.body1,
    leadingIcon: @Composable (() -> Unit)? = null,
    trailingIcon: @Composable (() -> Unit)? = null,
    visualTransformation: VisualTransformation = VisualTransformation.None,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
    keyboardActions: KeyboardActions = KeyboardActions(),
    singleLine: Boolean = false,
    maxLines: Int = Int.MAX_VALUE
) {
    BasicTextField(
        modifier = modifier
            .background(
                color = CoffetionTheme.colors.white,
                shape = shape
            )
            .defaultMinSize(
                minWidth = minWidth,
                minHeight = minHeight
            ),
        value = value,
        onValueChange = onValueChange,
        enabled = enabled,
        cursorBrush = SolidColor(CoffetionTheme.colors.primary),
        textStyle = textStyle,
        visualTransformation = visualTransformation,
        keyboardOptions = keyboardOptions,
        keyboardActions = keyboardActions,
        singleLine = singleLine,
        maxLines = maxLines,
        decorationBox = { innerTextField ->
            Row(
                modifier = Modifier.padding(horizontal = 15.dp, vertical = 10.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                leadingIcon?.let {
                    leadingIcon()
                    Spacer(modifier = Modifier.width(10.dp))
                }
                innerTextField()
                trailingIcon?.let { 
                    Spacer(modifier = Modifier.width(10.dp))
                    trailingIcon()
                }
            }
        }
    )
}