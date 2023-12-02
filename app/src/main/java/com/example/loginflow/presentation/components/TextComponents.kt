package com.example.loginflow.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.loginflow.R
import com.example.loginflow.ui.theme.GrayColor
import com.example.loginflow.ui.theme.Primary
import com.example.loginflow.ui.theme.TextColor
import com.example.loginflow.ui.theme.WhiteColor
import com.example.loginflow.ui.theme.shapes

@Composable
fun NormalTextComponent(value: String) {
    Text(
        text = value,
        modifier = Modifier
            .fillMaxWidth()
            .heightIn(min = 40.dp),
        style = TextStyle(
            fontSize = 24.sp,
            fontWeight = FontWeight.Normal,
            fontStyle = FontStyle.Normal
        ),
        color = TextColor,
        textAlign = TextAlign.Center
    )
}

@Composable
fun HeadingTextComponent(value: String) {
    Text(
        text = value,
        modifier = Modifier
            .fillMaxWidth()
            .heightIn(),
        style = TextStyle(
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold,
            fontStyle = FontStyle.Normal
        ),
        color = TextColor,
        textAlign = TextAlign.Center
    )
}

@Composable
fun UserTextField(labelValue: String, painterResource: Painter) {
    val textValue = remember { mutableStateOf("") }

    OutlinedTextField(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.White)
            .clip(shapes.small),
        label = { Text(text = labelValue) },
        value = textValue.value,
        onValueChange = {
            textValue.value = it
        },
        colors = TextFieldDefaults.colors(
            focusedLabelColor = Primary,
            cursorColor = Primary,
            focusedContainerColor = WhiteColor,
        ),
        keyboardOptions = KeyboardOptions(imeAction = ImeAction.Next),
        singleLine = true,
        maxLines = 1,
        leadingIcon = {
            Icon(
                modifier = Modifier.size(20.dp),
                painter = painterResource,
                contentDescription = null
            )
        }
    )
}

@Composable
fun PasswordTextField(labelValue: String, painterResource: Painter) {
    val password = remember { mutableStateOf("") }
    val passwordVisible = remember { mutableStateOf(false) }
    val localFocus = LocalFocusManager.current

    OutlinedTextField(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.White)
            .clip(shapes.small),
        label = { Text(text = labelValue) },
        value = password.value,
        onValueChange = {
            password.value = it
        },

        colors = TextFieldDefaults.colors(
            focusedLabelColor = Primary,
            cursorColor = Primary,
            focusedContainerColor = WhiteColor,
        ),

        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Password,
            imeAction = ImeAction.Done
        ),
        singleLine = true,
        maxLines = 1,
        keyboardActions = KeyboardActions {
            localFocus.clearFocus()
        },
        leadingIcon = {
            Icon(
                modifier = Modifier.size(20.dp),
                painter = painterResource,
                contentDescription = null
            )
        },

        trailingIcon = {
            val iconImage = if (passwordVisible.value) {
                Icons.Filled.Visibility
            } else {
                Icons.Filled.VisibilityOff
            }

            val description = if (passwordVisible.value) {
                stringResource(id = R.string.hide_password)
            } else {
                stringResource(id = R.string.show_password)

            }

            IconButton(onClick = { passwordVisible.value = !passwordVisible.value }) {
                Icon(imageVector = iconImage, contentDescription = description)
            }
        },

        visualTransformation = if (passwordVisible.value) {
            VisualTransformation.None
        } else {
            PasswordVisualTransformation()
        }
    )
}

@Composable
fun UnderlinedTextComponent(value: String) {
    Text(
        text = value,
        modifier = Modifier
            .fillMaxWidth()
            .heightIn(min = 40.dp),
        style = TextStyle(
            fontSize = 16.sp,
            fontWeight = FontWeight.Normal,
            fontStyle = FontStyle.Normal
        ),
        color = GrayColor,
        textAlign = TextAlign.Center,
        textDecoration = TextDecoration.Underline
    )
}