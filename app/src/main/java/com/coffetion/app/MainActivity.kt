package com.coffetion.app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.coffetion.design_system.atoms.Button
import com.coffetion.design_system.atoms.ProvideTextStyle
import com.coffetion.design_system.atoms.Surface
import com.coffetion.design_system.atoms.Text
import com.coffetion.design_system.theme.CoffetionTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CoffetionTheme {

            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewMain() {
    CoffetionTheme {

    }
}
