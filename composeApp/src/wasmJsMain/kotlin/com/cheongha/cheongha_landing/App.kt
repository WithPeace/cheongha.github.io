package com.cheongha.cheongha_landing

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.platform.LocalWindowInfo
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import cheongha_landing.composeapp.generated.resources.Res
import cheongha_landing.composeapp.generated.resources.service_logo
import org.jetbrains.compose.resources.painterResource

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun App() {
    MaterialTheme {
        val screenWidth = with(LocalDensity.current) {
            LocalWindowInfo.current.containerSize.width.toDp()
        }
        val screenHeight = with(LocalDensity.current) {
            LocalWindowInfo.current.containerSize.height.toDp()
        }
        var showContent by remember { mutableStateOf(false) }
        val scrollState = rememberScrollState()
        Column(
            modifier = Modifier.fillMaxWidth().verticalScroll(scrollState),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Intro(screenWidth = screenWidth, screenHeight = screenHeight)

        }
    }
}

@Composable
private fun Intro(
    modifier: Modifier = Modifier,
    screenWidth: Dp,
    screenHeight: Dp,
) {
    Column(
        modifier =
        modifier.size(width = screenWidth, height = screenHeight).background(
            brush =
            Brush.verticalGradient(
                listOf(
                    Color(0xFFB99BEC),
                    Color(0xFFC7B5F1),
                    Color(0xFFFFFFFF),
                ),
            ),
        ).padding(vertical = 130.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Box {
            Image(painterResource(Res.drawable.service_logo), null)
            Column(modifier.align(Alignment.BottomCenter)) {
                Text("청년에 의한, 청년을 위한,청하", style =  TextStyle())
            }
        }
    }
}
// 폰트 적용 + 디자인 시스템 구축