package com.example.loginflow.navigation

sealed class NavScreen(val route: String) {
    object SignUpScreen : NavScreen("signup_screen")
    object ConditionsScreen : NavScreen("conditions_screen")
}