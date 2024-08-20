package com.cheongha.cheongha_landing

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.platform.LocalWindowInfo
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import cheongha_landing.composeapp.generated.resources.Res
import cheongha_landing.composeapp.generated.resources.service_logo
import kotlinx.browser.window
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
        val scrollState = rememberScrollState()
        Column(
            modifier = Modifier.fillMaxWidth().verticalScroll(scrollState),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Intro(screenWidth = screenWidth, screenHeight = screenHeight)
            Content()
            Outro(screenWidth = screenWidth, screenHeight = screenHeight)
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
        ),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Column(
            verticalArrangement = Arrangement.Center,
            modifier = modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = modifier.height(79.dp))
            Image(
                painter = painterResource(Res.drawable.service_logo),
                contentDescription = null
            )
            Spacer(modifier.height(56.17.dp))
            Text(
                text = buildAnnotatedString {
                    withStyle(
                        style = SpanStyle(
                            fontWeight = FontWeight.SemiBold,
                            color = Color(0xFF000000)
                        ),
                    ) {
                        append("청년에 의한, 청년을 위한,\n")
                    }
                    append("청하")
                },
                textAlign = TextAlign.Center,
                style = fontFamily.h1,
            )
            Spacer(modifier.height(38.dp))
            Row(modifier = modifier.wrapContentHeight()) {
                TextButton(
                    onClick = {
                        window.open("https://play.google.com/store/apps/details?id=com.withpeace.withpeace")
                    },
                    modifier = modifier.clip(RoundedCornerShape(5.dp))
                        .background(Color(0xFF9A70E2)),
                    contentPadding = PaddingValues(vertical = 12.dp, horizontal = 14.dp)
                ) {
                    Text(
                        "Google Play",
                        style = fontFamily.button,
                        modifier = modifier
//                            .padding(start = 10.dp)
                    )
                }
                Spacer(modifier.width(16.dp))
                TextButton(
                    onClick = {
                        window.open("https://apps.apple.com/kr/app/%EC%B2%AD%ED%95%98/id6504498223")
                    },
                    modifier = modifier.clip(RoundedCornerShape(5.dp))
                        .background(Color(0xFF9A70E2)),
                    contentPadding = PaddingValues(vertical = 12.dp, horizontal = 14.dp)
                ) {
                    Text(
                        "App Store",
                        style = fontFamily.button,
                        modifier = modifier
//                            .padding(start = 10.dp)
                    )
                }
            }
        }
    }
}

@Composable
private fun Content(
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier.fillMaxWidth()) { }
}

@Composable
private fun Outro(
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
                    Color(0xFFFFFFFF),
                    Color(0xFFC7B5F1),
                    Color(0xFFB99BEC),


                    ),
            ),
        ),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Column(
            verticalArrangement = Arrangement.Center,
            modifier = modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = modifier.height(79.dp))
            Image(
                painter = painterResource(Res.drawable.service_logo),
                contentDescription = null
            )
            Spacer(modifier.height(56.17.dp))
            Text(
                text = buildAnnotatedString {
                    withStyle(
                        style = SpanStyle(
                            fontWeight = FontWeight.SemiBold,
                            color = Color(0xFF000000)
                        ),
                    ) {
                        append("청년에 의한, 청년을 위한,\n")
                    }
                    append("청하")
                },
                textAlign = TextAlign.Center,
                style = fontFamily.h1,
            )
            Spacer(modifier.height(38.dp))
            Row(modifier = modifier.wrapContentHeight()) {
                TextButton(
                    onClick = {
                        window.open("https://play.google.com/store/apps/details?id=com.withpeace.withpeace")
                    },
                    modifier = modifier.clip(RoundedCornerShape(5.dp))
                        .background(Color(0xFF9A70E2)),
                    contentPadding = PaddingValues(vertical = 12.dp, horizontal = 14.dp)
                ) {
                    Text(
                        "Google Play",
                        style = fontFamily.button,
                        modifier = modifier
//                            .padding(start = 10.dp)
                    )
                }
                Spacer(modifier.width(16.dp))
                TextButton(
                    onClick = {
                        window.open("https://apps.apple.com/kr/app/%EC%B2%AD%ED%95%98/id6504498223")
                    },
                    modifier = modifier.clip(RoundedCornerShape(5.dp))
                        .background(Color(0xFF9A70E2)),
                    contentPadding = PaddingValues(vertical = 12.dp, horizontal = 14.dp)
                ) {
                    Text(
                        "App Store",
                        style = fontFamily.button,
                        modifier = modifier
//                            .padding(start = 10.dp)
                    )
                }
            }
        }
    }
}
// 폰트 적용 + 디자인 시스템 구축