package com.coffetion.design_system.atoms

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp

@Composable
fun Avatar(
    modifier: Modifier = Modifier,
    painter: Painter,
    shape: Shape = CircleShape,
    type: AvatarType
) {
    Image(
        modifier = modifier
            .size(when (type) {
                AvatarType.Small -> 44.dp
                AvatarType.Large -> 250.dp
            })
            .clip(shape),
        painter = painter,
        contentScale = ContentScale.Crop,
        contentDescription = "Avatar Image"
    )
}

enum class AvatarType {
    Small, Large
}