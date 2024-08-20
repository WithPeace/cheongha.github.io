package com.cheongha.cheongha_landing

import androidx.compose.runtime.Immutable
import androidx.compose.ui.graphics.Color

internal val mainPurple = Color(0xFF9A70E2)
internal val subPurple = Color(0xFFE8E8FC)
internal val subSkyBlue = Color(0xFF90EFEF)
internal val subBlueGreen = Color(0xFFBDE4DF)
internal val subBlue1 = Color(0xFFDFF2F9)
internal val subBlue2 = Color(0xFF0575E6)

// Gradient
// Color(0xFFB99BEC),
// Color(0xFFC7B5F1),
// Color(0xFFFFFFFF),

val systemBlack = Color.Black
val systemWhite = Color.White

@Immutable
data class WithPeaceColor(
    val MainPurple: Color = mainPurple,
    val SubPurple: Color = subPurple,
    val SubSkyBlue: Color = subSkyBlue,
    val SubBlueGreen: Color = subBlueGreen,
    val SubBlue1: Color = subBlue1,
    val SubBlue2: Color = subBlue2,
    val SystemBlack: Color = systemBlack,
    val SystemWhite: Color = systemWhite,
)

val lightColor = WithPeaceColor()
val darkColor = WithPeaceColor()