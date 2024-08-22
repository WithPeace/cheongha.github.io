import androidx.compose.foundation.Image
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
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
import cheongha_landing.composeapp.generated.resources.Res
import cheongha_landing.composeapp.generated.resources.apple_logo_svgrepo_com
import cheongha_landing.composeapp.generated.resources.home_screen
import cheongha_landing.composeapp.generated.resources.playstore_svgrepo_com
import cheongha_landing.composeapp.generated.resources.post_screen
import cheongha_landing.composeapp.generated.resources.service_logo
import com.cheongha.cheongha_landing.fontFamilyMobile
import org.jetbrains.compose.resources.painterResource

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun App(
    onPlayStoreClick: () -> Unit,
    onAppStoreClick: () -> Unit,
) {
    MaterialTheme {
        val screenWidth = with(LocalDensity.current) {
            LocalWindowInfo.current.containerSize.width.toDp()
        }
        val screenHeight = with(LocalDensity.current) {
            LocalWindowInfo.current.containerSize.height.toDp()
        }
        val scrollState = rememberScrollState()
        if (screenWidth >= 600.dp) {
            LandingForWeb(
                scrollState, screenWidth, screenHeight,
                onPlayStoreClick = onPlayStoreClick, onAppStoreClick = onAppStoreClick
            )
        } else {
            LandingForMobile(
                scrollState,
                screenWidth,
                screenHeight,
                onPlayStoreClick = onPlayStoreClick,
                onAppStoreClick = onAppStoreClick
            )
        }
    }
}

@Composable
private fun LandingForMobile(
    scrollState: ScrollState,
    screenWidth: Dp,
    screenHeight: Dp,
    onPlayStoreClick: () -> Unit,
    onAppStoreClick: () -> Unit,
) {
    Column(
        modifier = Modifier.fillMaxWidth().verticalScroll(scrollState),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Intro(
            screenWidth = screenWidth,
            screenHeight = screenHeight,
            onPlayStoreClick = onPlayStoreClick,
            onAppStoreClick = onAppStoreClick
        )
        Content()
        Outro(
            screenWidth = screenWidth,
            screenHeight = screenHeight,
            onPlayStoreClick = onPlayStoreClick,
            onAppStoreClick = onAppStoreClick
        )
    }
}

@Composable
private fun Content(
    modifier: Modifier = Modifier,
) {
    Introduce()
    Column(modifier.fillMaxWidth().background(Color(0xFFF9F9F9))) {

        Spacer(modifier = modifier.height(25.dp))
        Text(
            "홈 - 청년정책", style = fontFamilyMobile.subtitle1,
            modifier = modifier.padding(start = 24.dp)
        )
        Spacer(modifier = modifier.height(13.dp))
        Text(
            "다양한 청년정책,\n" + "놓치지 않게",
            style = fontFamilyMobile.subtitle2,
            modifier = modifier.padding(start = 24.dp)
        )
        Spacer(modifier = modifier.height(21.dp))
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = modifier.fillMaxWidth()
        ) {
            Image(
                alignment = Alignment.Center,
                contentScale = ContentScale.FillWidth,
                painter = painterResource(Res.drawable.home_screen),
                contentDescription = "",
                modifier = modifier.width(246.dp)
            )
        }
        Spacer(modifier.height(54.dp))
    }
    Column(modifier.fillMaxWidth()) {
        Spacer(modifier = modifier.height(52.dp))
        Text(
            "커뮤니티", style = fontFamilyMobile.subtitle1,
            modifier = modifier.padding(start = 24.dp)
        )
        Spacer(modifier = modifier.height(13.dp))
        Text(
            "나와 같은 청년들과 함께",
            style = fontFamilyMobile.subtitle2,
            modifier = modifier.padding(start = 24.dp)
        )
        Spacer(modifier = modifier.height(21.dp))
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = modifier.fillMaxWidth()
        ) {
            Image(
                alignment = Alignment.Center,
                contentScale = ContentScale.FillWidth,
                painter = painterResource(Res.drawable.post_screen),
                contentDescription = "",
                modifier = modifier.width(246.dp)
            )
        }
        Spacer(modifier.height(77.dp))
    }
}

@Composable
private fun Introduce(
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = modifier.height(28.dp))
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
            style = fontFamilyMobile.h1,
        )
        Spacer(modifier.height(52.dp))
        Text(
            text = buildAnnotatedString {
                withStyle(
                    style = SpanStyle(
                        color = Color(0xFF9A70E2)
                    )
                ) {
                    append("청하(청년하랑)")
                }
                append("는")
                withStyle(
                    style = SpanStyle(
                        color = Color(0xFF9A70E2)
                    )
                ) {
                    append(" '청년'")
                }
                append("과 “함께 높이 날다”\n라는 의미를 가진 순우리말")
                withStyle(
                    style = SpanStyle(
                        color = Color(0xFF9A70E2)
                    )
                ) {
                    append(" '하랑'")
                }
                append("을 합쳐,\n\n우리 청년들이 이루고자 하는 목표를 위해\n함께 날아가고자 만들어진 서비스예요.\n\n")
                append("청하에서 여러분이 이루고자 하는 목표를\n 위한 첫걸음을 시작해 보세요.")
            },
            textAlign = TextAlign.Center,
            style = fontFamilyMobile.caption
        )
        Spacer(modifier.height(52.dp))
    }
}

@Composable
private fun Outro(
    modifier: Modifier = Modifier,
    screenWidth: Dp,
    screenHeight: Dp,
    onPlayStoreClick: () -> Unit,
    onAppStoreClick: () -> Unit,
) {
    val lineHeightDp: Dp = with(LocalDensity.current) {
        fontFamilyMobile.button.lineHeight.toDp()
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
            Spacer(modifier = modifier.height(56.dp))
            Image(
                modifier = modifier.width(154.dp),
                contentScale = ContentScale.FillWidth,
                painter = painterResource(Res.drawable.service_logo),
                contentDescription = null
            )
            Spacer(modifier.height(83.dp))
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
                style = fontFamilyMobile.h1,
            )
            Spacer(modifier.height(27.dp))
            Row {
                TextButton(
                    onClick = {
                        onPlayStoreClick()
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
                        style = fontFamilyMobile.button,
                        modifier = modifier
                            .padding(start = 10.dp)
                    )
                }
                Spacer(modifier.width(16.dp))
                TextButton(
                    onClick = {
                        onAppStoreClick()
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
                        style = fontFamilyMobile.button,
                        modifier = modifier
                            .padding(start = 13.dp)
                    )
                }
            }
        }
    }
}

@Composable
private fun Intro(
    modifier: Modifier = Modifier,
    screenWidth: Dp,
    screenHeight: Dp,
    onPlayStoreClick: () -> Unit,
    onAppStoreClick: () -> Unit,
) {
    val lineHeightDp: Dp = with(LocalDensity.current) {
        fontFamilyMobile.button.lineHeight.toDp()
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
            Spacer(modifier = modifier.height(56.dp))
            Image(
                modifier = modifier.width(154.dp),
                contentScale = ContentScale.FillWidth,
                painter = painterResource(Res.drawable.service_logo),
                contentDescription = null
            )
            Spacer(modifier.height(83.dp))
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
                style = fontFamilyMobile.h1,
            )
            Spacer(modifier.height(27.dp))
            Row {
                TextButton(
                    onClick = {
                        onPlayStoreClick()
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
                        style = fontFamilyMobile.button,
                        modifier = modifier
                            .padding(start = 10.dp)
                    )
                }
                Spacer(modifier.width(16.dp))
                TextButton(
                    onClick = {
                        onAppStoreClick()
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
                        style = fontFamilyMobile.button,
                        modifier = modifier
                            .padding(start = 13.dp)
                    )
                }
            }
        }
    }
}

