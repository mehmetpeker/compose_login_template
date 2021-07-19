package com.mehmetpeker.logintemplate.ui.screen.login

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
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
