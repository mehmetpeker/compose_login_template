package com.mehmetpeker.logintemplate

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.core.view.WindowCompat
import com.google.accompanist.insets.ProvideWindowInsets
import com.mehmetpeker.logintemplate.ui.screen.login.Login
import com.mehmetpeker.logintemplate.ui.theme.LoginTemplateTheme

class MainActivity : ComponentActivity() {
    @ExperimentalAnimationApi
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
                        Login()
                    }
                }
            }

        }
    }
}
