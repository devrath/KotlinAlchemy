package com.istudio.app.modules.module_demos.coroutines.exception_handeling.using_launch

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
fun UsingLaunchExceptionHandleDemo(navController: NavHostController) {

    val viewModel: UsingLaunchExceptionHandleDemoVm = hiltViewModel()

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        Spacer(modifier = Modifier.height(20.dp))

        AppButton(text = "No Exception Handler") {
            viewModel.demo1()
        }

        Spacer(modifier = Modifier.height(20.dp))

        AppButton(text = "Catch locally using try catch") {
            viewModel.demo2()
        }

        Spacer(modifier = Modifier.height(20.dp))

        AppButton(text = "Try to catch on external catch") {
            viewModel.demo3()
        }

        Spacer(modifier = Modifier.height(20.dp))

        AppButton(text = "Using Exception Handler") {
            viewModel.demo4()
        }
    }

}