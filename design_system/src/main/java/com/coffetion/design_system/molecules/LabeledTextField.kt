package com.coffetion.design_system.molecules

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import com.coffetion.design_system.atoms.Text
import com.coffetion.design_system.atoms.TextField
import com.coffetion.design_system.theme.CoffetionTheme

@Composable
fun LabeledTextField(
    modifier: Modifier = Modifier,
    value: String,
    onValueChange: (String) -> Unit,
    enabled: Boolean = true,
    shape: Shape = CoffetionTheme.shapes.large,
    label: String,
    labelTextColor: Color = CoffetionTheme.colors.black,
    labelTextStyle: TextStyle = CoffetionTheme.typography.body2,
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
    Column(modifier = modifier) {
        Text(
            text = label,
            color = labelTextColor,
            style = labelTextStyle
        )
        Spacer(modifier = Modifier.height(10.dp))
        TextField(
            value = value,
            onValueChange = onValueChange,
            enabled = enabled,
            shape = shape,
            textStyle = textStyle,
            placeholder = placeholder,
            leadingIcon = leadingIcon,
            trailingIcon = trailingIcon,
            visualTransformation = visualTransformation,
            keyboardOptions = keyboardOptions,
            keyboardActions = keyboardActions,
            singleLine = singleLine,
            maxLines = maxLines
        )
    }
}