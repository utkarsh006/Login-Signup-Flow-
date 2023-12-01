package com.example.loginflow.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.loginflow.presentation.screens.ConditionsScreen
import com.example.loginflow.presentation.screens.SignUpScreen

@Composable
fun AppNavHost() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = NavScreen.SignUpScreen.route) {
        composable(route = NavScreen.SignUpScreen.route) {
            SignUpScreen(navController)
        }

        composable(route = NavScreen.ConditionsScreen.route) {
            ConditionsScreen(navController)
        }

    }

}