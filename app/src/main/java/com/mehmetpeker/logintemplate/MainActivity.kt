package com.mehmetpeker.logintemplate

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.core.view.WindowCompat
import com.mehmetpeker.logintemplate.ui.makeStatusBarTransparent
import com.mehmetpeker.logintemplate.ui.screen.recipe.RecipeScreen
import com.mehmetpeker.logintemplate.ui.theme.LoginTemplateTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        WindowCompat.setDecorFitsSystemWindows(window,false)
        setContent {
            LoginTemplateTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    RecipeScreen()
                }
            }
        }
    }
}
