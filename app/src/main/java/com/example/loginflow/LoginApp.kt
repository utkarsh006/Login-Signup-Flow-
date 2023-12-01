package com.example.loginflow

import androidx.compose.animation.Crossfade
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.example.loginflow.navigation.AppRouter
import com.example.loginflow.navigation.Screen
import com.example.loginflow.presentation.screens.ConditionsScreen
import com.example.loginflow.presentation.screens.SignUpScreen

@Composable
fun MainScreen() {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = Color.White
    ) {
        Crossfade(targetState = AppRouter.currentScreen, label = "") { currentState ->
            when (currentState.value) {
                is Screen.SignUpScreen -> {
                    SignUpScreen()
                }

                is Screen.ConditionsScreen -> {
                    ConditionsScreen()
                }
            }

        }
    }
}