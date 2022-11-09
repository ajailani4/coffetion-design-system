package com.coffetion.design_system.theme

import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.coffetion.design_system.R

val PoppinsFamily = FontFamily(
    Font(R.font.poppins_regular, FontWeight.Normal),
    Font(R.font.poppins_semibold, FontWeight.SemiBold),
    Font(R.font.poppins_bold, FontWeight.Bold)
)

class CoffetionTypography internal constructor(
    val h1: TextStyle,
    val h2: TextStyle,
    val h3: TextStyle,
    val title1: TextStyle,
    val title2: TextStyle,
    val body1: TextStyle,
    val body2: TextStyle,
    val overline: TextStyle
) {
    constructor(
        defaultFontFamily: FontFamily = PoppinsFamily,
        h1: TextStyle = TextStyle(
            fontWeight = FontWeight.SemiBold,
            fontSize = 32.sp
        ),
        h2: TextStyle = TextStyle(
            fontWeight = FontWeight.SemiBold,
            fontSize = 28.sp
        ),
        h3: TextStyle = TextStyle(
            fontWeight = FontWeight.SemiBold,
            fontSize = 24.sp
        ),
        title1: TextStyle = TextStyle(
            fontWeight = FontWeight.SemiBold,
            fontSize = 20.sp
        ),
        title2: TextStyle = TextStyle(
            fontWeight = FontWeight.SemiBold,
            fontSize = 16.sp
        ),
        body1: TextStyle = TextStyle(
            fontWeight = FontWeight.Normal,
            fontSize = 14.sp
        ),
        body2: TextStyle = TextStyle(
            fontWeight = FontWeight.Normal,
            fontSize = 12.sp
        ),
        overline: TextStyle = TextStyle(
            fontWeight = FontWeight.Normal,
            fontSize = 10.sp
        )
    ) : this(
        h1 = h1.withDefaultFontFamily(defaultFontFamily),
        h2 = h2.withDefaultFontFamily(defaultFontFamily),
        h3 = h3.withDefaultFontFamily(defaultFontFamily),
        title1 = title1.withDefaultFontFamily(defaultFontFamily),
        title2 = title2.withDefaultFontFamily(defaultFontFamily),
        body1 = body1.withDefaultFontFamily(defaultFontFamily),
        body2 = body2.withDefaultFontFamily(defaultFontFamily),
        overline = overline.withDefaultFontFamily(defaultFontFamily)
    )

    fun copy(
        h1: TextStyle,
        h2: TextStyle,
        h3: TextStyle,
        title1: TextStyle,
        title2: TextStyle,
        body1: TextStyle,
        body2: TextStyle,
        overline: TextStyle
    ): CoffetionTypography = CoffetionTypography(
        h1 = h1,
        h2 = h2,
        h3 = h3,
        title1 = title1,
        title2 = title2,
        body1 = body1,
        body2 = body2,
        overline = overline
    )
}

private fun TextStyle.withDefaultFontFamily(default: FontFamily): TextStyle {
    return if (fontFamily != null) this else copy(fontFamily = default)
}

internal val LocalTypography = staticCompositionLocalOf { CoffetionTypography() }
