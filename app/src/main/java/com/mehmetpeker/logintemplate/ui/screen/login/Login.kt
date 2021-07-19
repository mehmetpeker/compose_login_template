package com.mehmetpeker.logintemplate.ui.screen.login

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.*
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.google.accompanist.insets.ProvideWindowInsets
import com.google.accompanist.insets.statusBarsPadding
import com.mehmetpeker.logintemplate.R
import com.mehmetpeker.logintemplate.ui.theme.PoppinsFontFamily
import com.mehmetpeker.logintemplate.ui.theme.PoppinsRegularFontFamily
import com.mehmetpeker.logintemplate.ui.theme.login_login_btn_color

@Composable
fun Login() {
    ProvideWindowInsets {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(color = Color.White)
                .statusBarsPadding()
        ) {
            LoginAppBar(
                modifier = Modifier
                    .height(56.dp)
                    .fillMaxWidth()
            )
            LoginForm()
        }
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

@Composable
fun LoginForm() {
    Column(
        Modifier
            .fillMaxSize()
            .padding(horizontal = 24.dp)
            .absolutePadding(top = 16.dp)
    ) {

        EmailTextField()
        VerticalSpacer(value = 16)
        PasswordTextField()
        VerticalSpacer(value = 16)

        Text(
            "Forgot Password?",
            fontFamily = PoppinsRegularFontFamily,
            fontSize = 15.sp,
            color = login_login_btn_color,
            fontWeight = FontWeight.SemiBold
        )
        VerticalSpacer(value = 32)
        LoginButton(onClick = { }, color = login_login_btn_color) {
            Text(
                "Log in", color = Color.White,
                fontFamily = PoppinsRegularFontFamily,
                fontWeight = FontWeight.Bold
            )
        }
        VerticalSpacer(value = 24)
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

        VerticalSpacer(value = 24)
        ORString()
        VerticalSpacer(value = 16)
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
        VerticalSpacer(value = 16)
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
        VerticalSpacer(value = 16)
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

@Composable
fun ORString() {
    Box(contentAlignment = Alignment.Center) {
        Box(
            Modifier
                .height(1.dp)
                .fillMaxWidth()
                .background(Color(0xffDEDEDE), shape = RectangleShape)
                .clip(RectangleShape)
        )
        Text(
            "OR",
            modifier = Modifier
                .background(Color.White, shape = RoundedCornerShape(50))
                .padding(8.dp),
            fontWeight = FontWeight.Bold,
            fontSize = 17.sp,
            letterSpacing = 1.5.sp,
            fontFamily = PoppinsFontFamily
        )
    }
}

fun SignUpText(): AnnotatedString {
    return buildAnnotatedString {
        withStyle(style = SpanStyle(color = Color(0xff4C5673))) {
            append("Don’t have an account?")
        }
        withStyle(style = SpanStyle(fontWeight = FontWeight.Bold, color = login_login_btn_color)) {
            append("Sign up")
        }
    }
}

@Composable
fun VerticalSpacer(value: Int) {
    Spacer(Modifier.height(value.dp))
}
