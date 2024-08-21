package com.cheongha.cheongha_landing

import androidx.compose.foundation.Canvas
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
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.material.Typography
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.BlurredEdgeTreatment
import androidx.compose.ui.draw.blur
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.platform.LocalWindowInfo
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import cheongha_landing.composeapp.generated.resources.Res
import cheongha_landing.composeapp.generated.resources.apple_logo_svgrepo_com
import cheongha_landing.composeapp.generated.resources.filter_screen
import cheongha_landing.composeapp.generated.resources.home_screen
import cheongha_landing.composeapp.generated.resources.playstore_svgrepo_com
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
    val lineHeightDp: Dp = with(LocalDensity.current) {
        fontFamily.button.lineHeight.toDp()
    }
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
            Row {
                TextButton(
                    onClick = {
                        window.open("https://play.google.com/store/apps/details?id=com.withpeace.withpeace")
                    },
                    modifier = modifier.clip(RoundedCornerShape(5.dp))
                        .background(Color(0xFF9A70E2)),
                    contentPadding = PaddingValues(vertical = 12.dp, horizontal = 14.dp)
                ) {
                    Image(
                        modifier = modifier.height(lineHeightDp),
                        painter = painterResource(Res.drawable.playstore_svgrepo_com),
                        contentScale = ContentScale.FillHeight,
                        contentDescription = "",
                    )
                    Text(
                        "Google Play",
                        style = fontFamily.button,
                        modifier = modifier
                            .padding(start = 10.dp)
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
                    Image(
                        modifier = modifier.height(lineHeightDp),
                        painter = painterResource(Res.drawable.apple_logo_svgrepo_com),
                        contentScale = ContentScale.FillHeight,
                        contentDescription = "",
                    )
                    Text(
                        "App Store",
                        style = fontFamily.button,
                        modifier = modifier
                            .padding(start = 13.dp)
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
    Introduce(modifier)
    Spacer(modifier.height(171.dp))
    Column(modifier = modifier.fillMaxWidth().padding(start = 130.dp)) {
        HomeDescription(fontFamily, modifier)
        Spacer(modifier.height(48.dp))
    }
}

@Composable
private fun HomeDescription(
    fontFamily: Typography,
    modifier: Modifier
) {
    Text("홈 - 청년정책", style = fontFamily.subtitle1)
    Spacer(modifier = modifier.height(32.dp))
    ConstraintLayout(modifier.fillMaxWidth()) {
        val (title1, filterScreen,
            homeScreen, brushFirst,
            filterDescription, brushSecond) = createRefs()

        Text(
            modifier = modifier.constrainAs(title1, constrainBlock = {
                top.linkTo(parent.top)
                start.linkTo(parent.start)
            }),
            text = "다양한 청년정책,\n" +
                    "놓치지 않게", style = fontFamily.h2
        )
        Canvas(
            modifier = modifier.offset(x = 126.dp, y = 139.dp)
                .blur(41.dp, BlurredEdgeTreatment.Unbounded)
                .constrainAs(brushFirst, constrainBlock = {
                    top.linkTo(parent.top)
                    end.linkTo(parent.end)
                })
                .size(916.dp),
            onDraw = {
                drawCircle(
                    Brush.verticalGradient(
                        listOf(
                            Color(0xFFB99BEC),
                            Color(0xFFD2C8F5),
                            Color(0xFFE8EEFC),
                        ),
                    ),
                )
            }
        )
        Canvas(
            modifier = modifier.offset(x = (-117).dp, y = 107.dp)
                .blur(59.dp, BlurredEdgeTreatment.Unbounded)
                .constrainAs(brushSecond,
                    constrainBlock = {
                        bottom.linkTo(parent.bottom)
                        start.linkTo(parent.start)
                    })
                .size(300.dp),
            onDraw = {
                drawCircle(
                    Brush.verticalGradient(
                        listOf(
                            Color(0x66BBEFF5),
                            Color(0x99B8EFF5),
                            Color(0xD990EFEF),
                        ),
                    ),
                )
            }
        )
        Image(
            contentScale = ContentScale.Crop,
            painter = painterResource(Res.drawable.home_screen), contentDescription = "",
            modifier = modifier.width(396.dp).constrainAs(homeScreen,
                constrainBlock = {
                    top.linkTo(title1.bottom)
                    start.linkTo(parent.start)
                }).padding(top = 292.dp)
        )
        Image(
            contentScale = ContentScale.Crop,
            painter = painterResource(Res.drawable.filter_screen), contentDescription = "",
            modifier = modifier.padding(end = 124.dp, top = 100.dp).width(396.dp)
                .constrainAs(filterScreen,
                    constrainBlock = {
                        top.linkTo(title1.top)
                        end.linkTo(parent.end)
                    })
        )
        Text(
            text = "청하에서 다양한 청년정책을 확인해보세요.\n" +
                    "분야별, 지역별로 검색할 수 있어요.",
            modifier = modifier.padding(end = 124.dp)
                .constrainAs(filterDescription) {
                    end.linkTo(parent.end)
                    top.linkTo(filterScreen.bottom)
                }.padding(top = 55.dp),
            style = fontFamily.overline,
            textAlign = TextAlign.Right
        )
    }
}

@Composable
private fun Introduce(
    modifier: Modifier
) {
    Column(modifier = modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
        Spacer(modifier.height(193.dp))
        Text(
            text = buildAnnotatedString {
                withStyle(
                    style = SpanStyle(
                        fontWeight = FontWeight.SemiBold,
                        color = Color(0xFF000000)
                    ),
                ) {
                    append("국내 유일무이\n")
                }
                append("청년")
                withStyle(
                    style = SpanStyle(
                        fontWeight = FontWeight.SemiBold,
                        color = Color(0xFF000000)
                    ),
                ) {
                    append("을 위한 플랫폼")
                }
            },
            textAlign = TextAlign.Center,
            style = fontFamily.h1,
        )
        Spacer(modifier = modifier.height(56.dp))
        Text(
            text = buildAnnotatedString {
                withStyle(
                    style = SpanStyle(
                        color = Color(0xFF9A70E2)
                    )
                ) {
                    append("청하(청년하랑)")
                }
                append("는 ‘청춘’과 “함께 높이 날다”라는 의미를 가진 순우리말 ‘하랑’을 합쳐, \n")
                append("우리 청년들이 이루고자 하는 목표를 위해 함께 날아가고자 만들어진 서비스예요.\n")
                append("청하에서 여러분이 이루고자 하는 목표를 위한 첫걸음을 시작해 보세요.")
            },
            textAlign = TextAlign.Center,
            style = fontFamily.caption
        )
    }
}

@Composable
private fun Outro(
    modifier: Modifier = Modifier,
    screenWidth: Dp,
    screenHeight: Dp,
) {
    val lineHeightDp: Dp = with(LocalDensity.current) {
        fontFamily.button.lineHeight.toDp()
    }
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
            Row(modifier = modifier) {
                TextButton(
                    onClick = {
                        window.open("https://play.google.com/store/apps/details?id=com.withpeace.withpeace")
                    },
                    modifier = modifier.clip(RoundedCornerShape(5.dp))
                        .background(Color(0xFF9A70E2)),
                    contentPadding = PaddingValues(vertical = 12.dp, horizontal = 14.dp)
                ) {

                    Image(
                        modifier = modifier.height(lineHeightDp),
                        painter = painterResource(Res.drawable.playstore_svgrepo_com),
                        contentScale = ContentScale.FillHeight,
                        contentDescription = "",
                    )
                    Text(
                        "Google Play",
                        style = fontFamily.button,
                        modifier = modifier
                            .padding(start = 10.dp)
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
                    Image(
                        modifier = modifier.height(lineHeightDp),
                        painter = painterResource(Res.drawable.apple_logo_svgrepo_com),
                        contentScale = ContentScale.FillHeight,
                        contentDescription = "",
                    )
                    Text(
                        "App Store",
                        style = fontFamily.button,
                        modifier = modifier
                            .padding(start = 13.dp)
                    )
                }
            }
        }
    }
}