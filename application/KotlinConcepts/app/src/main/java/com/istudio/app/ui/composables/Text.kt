package com.istudio.app.ui.composables

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign

@Composable
fun AppText(
    modifier: Modifier = Modifier,
    text: String
) {
    Text(text = text, textAlign = TextAlign.Center, modifier = Modifier.fillMaxWidth())
}