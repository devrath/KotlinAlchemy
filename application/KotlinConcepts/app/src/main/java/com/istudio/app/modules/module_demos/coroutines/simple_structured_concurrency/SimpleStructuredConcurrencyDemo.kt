package com.istudio.app.modules.module_demos.coroutines.simple_structured_concurrency

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Shapes
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.istudio.app.ui.composables.AppButton
import com.istudio.app.ui.composables.AppText

@Composable
fun SimpleStructuredConcurrencyDemo(navController: NavHostController) {

    val viewModel: SimpleStructuredConcurrencyDemoVm = hiltViewModel()

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        AppText(text = "Co-Routines")

        Spacer(modifier = Modifier.height(20.dp))

        AppButton(text = "Start nested \n Independent Co-routines") {
            viewModel.startNestedIndependentCoroutines()
        }

        Spacer(modifier = Modifier.height(5.dp))

        AppButton(text = "Start nested \n Linked Co-routines") {
            viewModel.startNestedLinkedCoroutines()
        }

        Spacer(modifier = Modifier.height(20.dp))

        AppButton(text = "Start nested \n Linked Co-routines \n with join") {
            viewModel.startNestedChildrenCoroutines()
        }

        Spacer(modifier = Modifier.height(20.dp))

        AppButton(text = "CANCEL") {
            viewModel.cancel()
        }

    }

}