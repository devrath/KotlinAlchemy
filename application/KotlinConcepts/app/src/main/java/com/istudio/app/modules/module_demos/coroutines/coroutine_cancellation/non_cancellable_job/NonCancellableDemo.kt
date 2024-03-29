package com.istudio.app.modules.module_demos.coroutines.coroutine_cancellation.non_cancellable_job

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.istudio.app.ui.composables.AppButton

@Composable
fun NonCancellableDemo(navController: NavHostController){

    val viewModel: NonCancellableDemoVm = hiltViewModel()

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {


        Spacer(modifier = Modifier.height(100.dp))

        AppButton(text = "Start \n with Thread-Sleep") {
            viewModel.startWithTreadSleep()
        }

        Spacer(modifier = Modifier.height(100.dp))

        Button(
            modifier = Modifier
                .background(
                    color = MaterialTheme.colorScheme.primary,
                    shape = RectangleShape
                ),
            onClick = {
                viewModel.cancel()
            }
        ) {
            Text(text = "Cancel")
        }

    }

}