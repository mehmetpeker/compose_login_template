package com.mehmetpeker.logintemplate

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.core.view.WindowCompat
import com.google.accompanist.insets.ProvideWindowInsets
import com.google.accompanist.insets.statusBarsPadding
import com.google.accompanist.insets.systemBarsPadding
import com.mehmetpeker.logintemplate.ui.makeStatusBarTransparent
import com.mehmetpeker.logintemplate.ui.screen.login.Login
import com.mehmetpeker.logintemplate.ui.screen.login.LoginAppBar
import com.mehmetpeker.logintemplate.ui.screen.recipe.RecipeScreen
import com.mehmetpeker.logintemplate.ui.theme.LoginTemplateTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        WindowCompat.setDecorFitsSystemWindows(window, false)
        setContent {
            ProvideWindowInsets {
                LoginTemplateTheme {
                    // A surface container using the 'background' color from the theme
                    Surface(
                        color = Color.Yellow,
                        modifier = Modifier.fillMaxSize()
                    ) {
                        RecipeScreen()
                    }
                }
            }

        }
    }
}
