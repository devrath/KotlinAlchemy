package com.istudio.app.modules.module_demos.coroutines.using_async_await

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.istudio.app.ui.composables.AppButton

@Composable
fun UsingAsyncAwaitDemo(navController: NavHostController) {

    val viewModel: UsingAsyncAwaitDemoVm = hiltViewModel()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,

    ) {

        Spacer(modifier = Modifier.height(20.dp))

        AppButton(text = "Demo") {
            viewModel.demo()
        }

        Spacer(modifier = Modifier.height(20.dp))

        AppButton(text = "Cancel-Root") {
            viewModel.rootCancel()
        }
    }

}