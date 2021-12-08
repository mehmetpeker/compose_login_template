package com.mehmetpeker.logintemplate.ui.screen.login

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.core.tween
import androidx.compose.animation.expandIn
import androidx.compose.animation.slideInHorizontally
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Density
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.google.accompanist.insets.ProvideWindowInsets
import com.google.accompanist.insets.statusBarsPadding
import com.mehmetpeker.logintemplate.R
import com.mehmetpeker.logintemplate.ui.theme.PoppinsFontFamily
import com.mehmetpeker.logintemplate.ui.theme.PoppinsRegularFontFamily
import com.mehmetpeker.logintemplate.ui.theme.login_login_btn_color

@ExperimentalAnimationApi
@Composable
fun Login() {
    var visibility by remember { mutableStateOf(false) }
    var density = LocalDensity.current
    var config = LocalConfiguration.current
    ProvideWindowInsets {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(color = Color.White)
                .statusBarsPadding()
        ) {
            AnimatedVisibility(
                visible = visibility,
                enter = slideInHorizontally(
                    initialOffsetX = {
                        with(density) { config.screenWidthDp.dp.roundToPx() * -1 }
                    },
                    animationSpec = tween(1200)
                )

            ) {
                LoginAppBar(
                    modifier = Modifier
                        .height(56.dp)
                        .fillMaxWidth()
                )
            }

            LoginForm(
                visibility,
                density,
                config.screenWidthDp
            )
        }
        LaunchedEffect(key1 = "key1", block = { visibility = true })
    }
}

@Composable
fun LoginAppBar(modifier: Modifier) {
    Box(
        modifier
    ) {
        Text(
            "Log in",
            modifier = Modifier.align(Alignment.Center),
            fontFamily = PoppinsFontFamily,
            fontSize = 18.sp
        )
        IconButton(
            modifier = Modifier
                .padding(start = 8.dp)
                .align(Alignment.CenterStart),
            onClick = {}) {
            Icon(Icons.Filled.ArrowBack, null)
        }
    }
}

@ExperimentalAnimationApi
@Composable
fun LoginForm(visibility: Boolean, density: Density, screenWidth: Int) {

    val slideInHorizontallyFromLeftAnimation = slideInHorizontally(
        initialOffsetX = {
            with(density) { screenWidth.dp.roundToPx() * -1 }
        },
        animationSpec = tween(1200)
    )
    val slideInHorizontallyFromRightAnimation = slideInHorizontally(
        initialOffsetX = {
            with(density) { screenWidth.dp.roundToPx() }
        },
        animationSpec = tween(1200)
    )
    val expandInFromCenterAnimation =
        expandIn(animationSpec = tween(1200), expandFrom = Alignment.Center)
    Column(
        Modifier
            .fillMaxSize()
            .padding(horizontal = 24.dp)
            .absolutePadding(top = 16.dp)
    ) {

        AnimatedVisibility(
            visible = visibility,
            enter = slideInHorizontallyFromLeftAnimation,
            content = { EmailTextField() }
        )
        VerticalSpacer(value = 16)

        AnimatedVisibility(
            visible = visibility,
            enter = slideInHorizontallyFromRightAnimation,
            content = { PasswordTextField() }
        )


        VerticalSpacer(value = 16)

        AnimatedVisibility(
            visible = visibility,
            enter = expandInFromCenterAnimation,
            content = {
                Text(
                    "Forgot Password?",
                    fontFamily = PoppinsRegularFontFamily,
                    fontSize = 15.sp,
                    color = login_login_btn_color,
                    fontWeight = FontWeight.SemiBold
                )
            }
        )
        VerticalSpacer(value = 32)

        AnimatedVisibility(
            visible = visibility,
            enter = expandInFromCenterAnimation
        ) {
            LoginButton(onClick = { }, color = login_login_btn_color) {
                Text(
                    "Log in", color = Color.White,
                    fontFamily = PoppinsRegularFontFamily,
                    fontWeight = FontWeight.Bold
                )
            }
        }


        VerticalSpacer(value = 24)
        AnimatedVisibility(
            visible = visibility,
            enter = expandInFromCenterAnimation
        ) {
            ClickableText(
                text = SignUpText(),
                style = TextStyle(
                    textAlign = TextAlign.Center,
                    fontSize = 17.sp,
                    letterSpacing = 1.5.sp
                ),
                modifier = Modifier.fillMaxWidth()
            ) {
                // perform action when text clicked
            }
        }


        VerticalSpacer(value = 24)
        AnimatedVisibility(
            visible = visibility,
            enter = expandInFromCenterAnimation
        ) {
            ORString()
        }

        VerticalSpacer(value = 16)
        AnimatedVisibility(
            visible = visibility,
            enter = expandInFromCenterAnimation
        ) {
            SignInButton(
                onClick = { },
                color = Color.White,
                text = "Sign in with Google",
                leadingIcon = {
                    Image(
                        painterResource(R.drawable.google),
                        contentDescription = "",
                        contentScale = ContentScale.Crop,
                        modifier = Modifier.size(24.dp)
                    )
                })
        }

        VerticalSpacer(value = 16)
        AnimatedVisibility(
            visible = visibility,
            enter = expandInFromCenterAnimation
        ) {
            SignInButton(
                onClick = { },
                color = Color.White,
                text = "Sign in with Apple",
                leadingIcon = {
                    Image(
                        painterResource(R.drawable.apple),
                        contentDescription = "",
                        contentScale = ContentScale.Crop,
                        modifier = Modifier.size(24.dp)
                    )
                })
        }

        VerticalSpacer(value = 16)
        AnimatedVisibility(
            visible = visibility,
            enter = expandInFromCenterAnimation
        ) {
            SignInButton(
                onClick = { },
                color = Color.White,
                text = "Sign in with Facebook",
                leadingIcon = {
                    Image(
                        painterResource(R.drawable.facebook),
                        contentDescription = "",
                        contentScale = ContentScale.Crop,
                        modifier = Modifier.size(24.dp)
                    )
                })
        }


    }
}

