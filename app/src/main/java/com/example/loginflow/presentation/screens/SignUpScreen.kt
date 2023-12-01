package com.example.loginflow.presentation.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.loginflow.R
import com.example.loginflow.navigation.NavScreen
import com.example.loginflow.presentation.components.CheckboxComponent
import com.example.loginflow.presentation.components.HeadingTextComponent
import com.example.loginflow.presentation.components.NormalTextComponent
import com.example.loginflow.presentation.components.PasswordTextField
import com.example.loginflow.presentation.components.UserTextField

@Composable
fun SignUpScreen(navController: NavController) {
    Surface(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(28.dp)
    ) {
        Column(modifier = Modifier.fillMaxSize()) {
            NormalTextComponent(value = stringResource(id = R.string.hey))
            HeadingTextComponent(value = stringResource(id = R.string.create_account))

            Spacer(modifier = Modifier.height(20.dp))

            UserTextField(
                labelValue = stringResource(id = R.string.first_name),
                painterResource(id = R.drawable.profile)
            )

            UserTextField(
                labelValue = stringResource(id = R.string.last_name),
                painterResource(id = R.drawable.profile)
            )

            UserTextField(
                labelValue = stringResource(id = R.string.email),
                painterResource(id = R.drawable.mail)
            )

            PasswordTextField(
                labelValue = stringResource(id = R.string.password),
                painterResource(id = R.drawable.lock)
            )

            CheckboxComponent(
                text = stringResource(id = R.string.terms_and_conditions),
                onTextSelected = { navController.navigate(NavScreen.ConditionsScreen.route) }
            )

        }

    }
}
