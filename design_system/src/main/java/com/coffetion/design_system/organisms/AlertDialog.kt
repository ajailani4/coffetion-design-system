package com.coffetion.design_system.organisms

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import com.coffetion.design_system.atoms.Button
import com.coffetion.design_system.atoms.Surface
import com.coffetion.design_system.atoms.Text
import com.coffetion.design_system.theme.CoffetionTheme

@Composable
fun AlertDialog(
    modifier: Modifier = Modifier,
    shape: Shape = CoffetionTheme.shapes.large,
    image: @Composable () -> Unit,
    title: String,
    text: String,
    confirmText: String,
    onConfirmed: () -> Unit,
    dismissText: String,
    onDismissed: () -> Unit,
) {
    Dialog(onDismissRequest = onDismissed) {
        Surface(
            modifier = modifier,
            shape = shape,
            color = Color.White
        ) {
            Column(
                modifier = Modifier.padding(24.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                image()
                Spacer(modifier = Modifier.height(5.dp))
                Text(
                    text = title,
                    style = CoffetionTheme.typography.h2,
                    textAlign = TextAlign.Center
                )
                Spacer(modifier = Modifier.height(2.dp))
                Text(
                    text = text,
                    style = CoffetionTheme.typography.body1,
                    textAlign = TextAlign.Center
                )
                Spacer(modifier = Modifier.height(13.dp))
                Button(
                    modifier = Modifier.fillMaxWidth(),
                    onClick = onConfirmed
                ) {
                    Text(
                        text = confirmText,
                        style = CoffetionTheme.typography.title2
                    )
                }
                Spacer(modifier = Modifier.height(18.dp))
                Button(
                    modifier = Modifier.fillMaxWidth(),
                    border = BorderStroke(
                        width = 1.dp,
                        color = CoffetionTheme.colors.primary
                    ),
                    color = Color.White,
                    onClick = onDismissed
                ) {
                    Text(
                        text = dismissText,
                        style = CoffetionTheme.typography.title2
                    )
                }
            }
        }
    }
}

