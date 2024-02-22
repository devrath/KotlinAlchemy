package com.istudio.app.modules.module_demos.coroutines.compare_join_and_async

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.istudio.app.ui.composables.AppButton

@Composable
fun CompareJoinAsyncDemo(navController: NavHostController) {

    val viewModel: CompareJoinAsyncDemoVm = hiltViewModel()

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        Spacer(modifier = Modifier.height(20.dp))

        AppButton(text = "Join Demo") {
            viewModel.joinDemo()
        }

        Spacer(modifier = Modifier.height(5.dp))

        AppButton(text = "Async Demo") {
            viewModel.asyncDemo()
        }

        Spacer(modifier = Modifier.height(20.dp))

        AppButton(text = "Cancel-Root") {
            viewModel.rootCancel()
        }
    }

}