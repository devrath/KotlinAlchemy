package com.istudio.app.ui.composables

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun AppButton(
    modifier : Modifier = Modifier,
    text : String,
    onClick : () -> Unit
) {

    Button(
        modifier = modifier.fillMaxWidth(),
        onClick = onClick ) {
        Text(text = text)
    }

}