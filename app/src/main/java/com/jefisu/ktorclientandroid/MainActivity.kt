package com.jefisu.ktorclientandroid

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.jefisu.ktorclientandroid.features.presentation.MainScreen
import com.jefisu.ktorclientandroid.ui.theme.KtorClientAndroidTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            KtorClientAndroidTheme {
                MainScreen()
            }
        }
    }
}