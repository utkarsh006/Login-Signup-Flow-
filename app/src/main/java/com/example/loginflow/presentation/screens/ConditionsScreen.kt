package com.example.loginflow.presentation.screens

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavController
import com.example.loginflow.R
import com.example.loginflow.presentation.components.HeadingTextComponent

@Composable
fun ConditionsScreen(navController: NavController) {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = Color.White
    ) {
        HeadingTextComponent(value = stringResource(id = R.string.terms_and_conditions_header))
    }
}