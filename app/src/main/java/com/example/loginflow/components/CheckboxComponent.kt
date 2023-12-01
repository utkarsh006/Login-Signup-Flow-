package com.example.loginflow.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material3.Checkbox
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import com.example.loginflow.ui.theme.Primary

@Composable
fun CheckboxComponent(text: String) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .heightIn(56.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        val isChecked = remember { mutableStateOf(false) }

        Checkbox(
            checked = isChecked.value,
            onCheckedChange = {
                isChecked.value = !isChecked.value
            }
        )

        ClickableTextComponent(text = text)

    }
}

@Composable
fun ClickableTextComponent(text: String) {
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
                .firstOrNull()?.also {

                }
        }
    )
}