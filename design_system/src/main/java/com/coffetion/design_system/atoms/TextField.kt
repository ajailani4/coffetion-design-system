package com.coffetion.design_system.atoms

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.takeOrElse
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import com.coffetion.design_system.theme.CoffetionTheme
import com.coffetion.design_system.theme.LocalContentColor

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
    placeholder: @Composable (() -> Unit)? = null,
    leadingIcon: @Composable (() -> Unit)? = null,
    trailingIcon: @Composable (() -> Unit)? = null,
    visualTransformation: VisualTransformation = VisualTransformation.None,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
    keyboardActions: KeyboardActions = KeyboardActions(),
    singleLine: Boolean = false,
    maxLines: Int = Int.MAX_VALUE
) {
    var isFocused by remember { mutableStateOf(false) }
    val valueColor = textStyle.color.takeOrElse {
        LocalContentColor.current
    }
    val placeholderColor = CoffetionTheme.colors.white2
    val mergedTextStyle = textStyle.merge(TextStyle(color = valueColor))

    BasicTextField(
        modifier = modifier
            .background(
                color = CoffetionTheme.colors.white,
                shape = shape
            )
            .defaultMinSize(
                minWidth = minWidth,
                minHeight = minHeight
            )
            .onFocusChanged { isFocused = it.isFocused },
        value = value,
        onValueChange = onValueChange,
        enabled = enabled,
        cursorBrush = SolidColor(CoffetionTheme.colors.primary),
        textStyle = mergedTextStyle,
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
                placeholder?.let {
                    if (value.isEmpty() && !isFocused) {
                        CompositionLocalProvider(
                            LocalContentColor provides placeholderColor
                        ) {
                            placeholder()
                        }
                    }
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