package com.coffetion.app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.tooling.preview.Preview
import com.coffetion.design_system.atoms.*
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
