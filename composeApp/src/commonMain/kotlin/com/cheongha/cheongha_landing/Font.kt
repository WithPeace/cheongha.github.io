package com.cheongha.cheongha_landing


import androidx.compose.material.Typography
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import cheongha_landing.composeapp.generated.resources.Res
import cheongha_landing.composeapp.generated.resources.pretendard_bold
import cheongha_landing.composeapp.generated.resources.pretendard_extra_bold
import cheongha_landing.composeapp.generated.resources.pretendard_extra_light
import cheongha_landing.composeapp.generated.resources.pretendard_medium
import cheongha_landing.composeapp.generated.resources.pretendard_regular
import cheongha_landing.composeapp.generated.resources.pretendard_semi_bold
import cheongha_landing.composeapp.generated.resources.pretendard_thin
import org.jetbrains.compose.resources.Font

val fontFamily
    @Composable
    get() = Typography().run {
        val fontFamily = FontFamily(
            Font(
                Res.font.pretendard_bold,
                weight = FontWeight.Bold,
            ),
            Font(
                Res.font.pretendard_regular,
                weight = FontWeight.Normal,
            ),
            Font(
                Res.font.pretendard_extra_bold,
                weight = FontWeight.ExtraBold,
            ),
            Font(
                Res.font.pretendard_extra_light,
                weight = FontWeight.ExtraLight,
            ),
            Font(
                Res.font.pretendard_extra_light,
                weight = FontWeight.Light,
            ),
            Font(
                Res.font.pretendard_medium,
                weight = FontWeight.Medium,
            ),
            Font(
                Res.font.pretendard_semi_bold,
                weight = FontWeight.SemiBold,
            ),
            Font(
                Res.font.pretendard_thin,
                weight = FontWeight.Thin,
            ),
        )

        copy(
            h1 = h1.copy(
                lineHeight = 52.17.sp,
                fontSize = 40.sp,
                fontFamily = fontFamily,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF9A70E2),
            ),
            h2 = h2.copy(
                lineHeight = 52.17.sp,
                fontSize = 40.sp,
                fontFamily = fontFamily,
                fontWeight = FontWeight.SemiBold,
                color = Color.Black,
            ),
            h3 = h3.copy(fontFamily = fontFamily),
            h4 = h4.copy(fontFamily = fontFamily),
            h5 = h5.copy(fontFamily = fontFamily),
            h6 = h6.copy(fontFamily = fontFamily),
            subtitle1 = subtitle1.copy(
                fontFamily = fontFamily,
                color = Color(0xFF9A70E2),
                fontWeight = FontWeight.Bold,
                fontSize = 24.sp,
            ),
            subtitle2 = subtitle2.copy(
                fontFamily = fontFamily,
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp,
                color = Color(0xFF9A70E2),
            ),
            body1 = body1.copy(fontFamily = fontFamily),
            body2 = body2.copy(fontFamily = fontFamily),
            button = button.copy(
                fontFamily = fontFamily,
                color = Color.White,
                fontWeight = FontWeight.Bold,
                fontSize = 16.sp,
                letterSpacing = 0.sp,
            ),
            caption = caption.copy(
                fontFamily = fontFamily,
                color = Color.Black,
                fontWeight = FontWeight.Medium,
                fontSize = 26.sp,
                lineHeight = 34.sp
            ),
            overline = overline.copy(
                fontFamily = fontFamily,
                color = Color.Black,
                fontWeight = FontWeight.Medium,
                fontSize = 20.sp,
                lineHeight = 26.5.sp
            )
        )
    }
