package com.mehmetpeker.logintemplate.ui.screen.login

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mehmetpeker.logintemplate.ui.theme.*

@Composable
fun LoginButton(
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
    color: Color,
    content: @Composable RowScope.() -> Unit
) {
    Button(
        modifier = modifier
            .fillMaxWidth()
            .height(56.dp),
        onClick = onClick,
        shape = RoundedCornerShape(10.dp),
        colors = ButtonDefaults.buttonColors(
            backgroundColor = color
        ),
    ) {
        content()
    }
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun EmailTextField(
) {
    var emailState by remember { mutableStateOf("") }

    Card(
        onClick = { }, modifier = Modifier
            .height(56.dp)
            .fillMaxWidth()
    ) {
        TextField(
            colors = TextFieldDefaults.textFieldColors(
                backgroundColor = login_textfield_color,
                focusedIndicatorColor = Color.Transparent,
                disabledIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                cursorColor = login_textfield_stroke_color
            ),
            shape = RoundedCornerShape(10.dp),
            value = emailState,
            onValueChange = {
                emailState = it
            }, label = {
                Text(
                    "Email Address",
                    color = Color(0xff1C2439),
                    fontFamily = PoppinsRegularFontFamily
                )
            }
        )
    }
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun PasswordTextField(
) {
    var password by remember { mutableStateOf("") }

    Card(
        onClick = { }, modifier = Modifier
            .height(56.dp)
            .fillMaxWidth()
    ) {
        TextField(
            colors = TextFieldDefaults.textFieldColors(
                backgroundColor = login_textfield_color,
                focusedIndicatorColor = Color.Transparent,
                disabledIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                cursorColor = login_textfield_stroke_color
            ),
            shape = RoundedCornerShape(10.dp),
            value = password,
            onValueChange = {
                password = it
            }, label = {
                Text("Password", color = Color(0xff1C2439), fontFamily = PoppinsRegularFontFamily)
            },
            visualTransformation = PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password)
        )
    }
}
@Composable
fun SignInButton(
    modifier: Modifier = Modifier,
    leadingIcon: @Composable (() -> Unit)? = null,
    color: Color,
    text:String,
    onClick: () -> Unit,

) {
    Button(
        modifier = modifier
            .fillMaxWidth()
            .height(56.dp)
            .border(1.dp, brush = SolidColor(Color(0xff999999)), shape = RoundedCornerShape(8.dp)),
        onClick = onClick,
        shape = RoundedCornerShape(8.dp),
        colors = ButtonDefaults.buttonColors(
            backgroundColor = color
        ),
    ) {
        Box(modifier = Modifier.size(24.dp)){
            leadingIcon?.invoke()
        }
        Text(text,modifier = Modifier.fillMaxWidth(),textAlign = TextAlign.Center,fontFamily = PoppinsRegularFontFamily)
        Spacer(modifier = Modifier.size(24.dp))
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
