package com.example.loginflow.presentation.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.text.ClickableText
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.loginflow.ui.theme.Primary

@Composable
fun ClickableTextComponent(
    text: String,
    onTextSelected: (String) -> Unit
) {
    val initialText = "By continuing, you accept our "
    val privacyPolicyText = "Privacy Policy"
    val andText = " and "
    val termsText = "Terms of Use"

    val annotatedString = buildAnnotatedString {
        append(initialText)

        withStyle(style = SpanStyle(color = Primary)) {
            pushStringAnnotation(tag = privacyPolicyText, annotation = privacyPolicyText)
            append(privacyPolicyText)
        }

        append(andText)

        withStyle(style = SpanStyle(color = Primary)) {
            pushStringAnnotation(tag = termsText, annotation = termsText)
            append(termsText)
        }
    }

    ClickableText(
        text = annotatedString,
        onClick = { offset ->
            annotatedString.getStringAnnotations(offset, offset)
                .firstOrNull()?.also { span ->
                    if (span.item == termsText || span.item == privacyPolicyText) {
                        onTextSelected(span.item)
                    }
                }
        }
    )
}

@Composable
fun ClickableLoginTextComponent(
    tryingToLogin: Boolean = true,
    onTextSelected: (String) -> Unit
) {
    val initialText = if(tryingToLogin) {
        "Already have an account? "
    } else{
        "Don't have an account yet? "
    }

    val loginText = if(tryingToLogin) "Login" else "Register"

    val annotatedString = buildAnnotatedString {
        append(initialText)

        withStyle(style = SpanStyle(color = Primary)) {
            pushStringAnnotation(tag = loginText, annotation = loginText)
            append(loginText)
        }

    }

    ClickableText(
        modifier = Modifier
            .fillMaxWidth()
            .heightIn(min = 40.dp),
        style = TextStyle(
            fontSize = 20.sp,
            fontWeight = FontWeight.Normal,
            fontStyle = FontStyle.Normal,
            textAlign = TextAlign.Center
        ),
        text = annotatedString,
        onClick = { offset ->
            annotatedString.getStringAnnotations(offset, offset)
                .firstOrNull()?.also { span ->
                    if (span.item == loginText) {
                        onTextSelected(span.item)
                    }
                }
        }
    )
}