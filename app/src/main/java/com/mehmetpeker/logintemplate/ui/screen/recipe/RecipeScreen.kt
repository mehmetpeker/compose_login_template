package com.mehmetpeker.logintemplate.ui.screen.recipe

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mehmetpeker.logintemplate.R
import com.mehmetpeker.logintemplate.ui.theme.LoginTemplateTheme
import com.mehmetpeker.logintemplate.ui.theme.PlayfairFontFamily
import java.util.*

@Composable
fun RecipeScreen() {
    Box(Modifier.fillMaxSize()) {
        Image(
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.FillBounds,
            painter = painterResource(id = R.drawable.recipe1),
            contentDescription = null
        )
        ButtonColumn(
            Modifier
                .fillMaxWidth(50f)
                .padding(horizontal = 48.dp)
                .padding(top = 120.dp))
    }
}

@Composable
fun ButtonColumn(modifier: Modifier) {
    Column(modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            buildAnnotatedString {
                withStyle(
                    style = SpanStyle(
                        fontWeight = FontWeight.Bold,
                        color = Color.Black,
                        fontFamily = PlayfairFontFamily,
                        fontSize = with(LocalDensity.current) {
                            128.toSp()
                        },

                        )
                ) {
                    append("Recipe\n")
                }
                append("\nHelp you to cook healthy food")

            }, textAlign = TextAlign.Center
        )
        Spacer(modifier = Modifier.height(48.dp))
        RecipeButton(onClick = { }, color = Color(0xffFC7600)) {
            Text("GET STARTED", color = Color.White, fontWeight = FontWeight.Medium)
        }
        Spacer(modifier = Modifier.height(16.dp))
        RecipeButton(onClick = { }, color = Color.White) {
            Text("I HAVE AN ACCOUNT", fontWeight = FontWeight.Medium)
        }
    }
}

@Preview(
    showBackground =
    true
)
@Composable
fun ButtonColumnPreview() {
    LoginTemplateTheme {
        ButtonColumn(Modifier.wrapContentSize())
    }
}