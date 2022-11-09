package com.coffetion.app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.coffetion.design_system.atoms.ProvideTextStyle
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
