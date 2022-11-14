package com.coffetion.design_system.theme

import androidx.compose.foundation.shape.CornerBasedShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.unit.dp

class CoffetionShapes(
    val small: CornerBasedShape = RoundedCornerShape(10.dp),
    val medium: CornerBasedShape = RoundedCornerShape(15.dp),
    val large: CornerBasedShape = RoundedCornerShape(20.dp)
) {

}

internal val LocalShapes = staticCompositionLocalOf { CoffetionShapes() }
