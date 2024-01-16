package com.istudio.app.modules.module_demos.coroutines.exception_handeling

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.istudio.app.modules.module_selection.ModuleDemo
import com.istudio.app.ui.composables.AppButton

@Composable
fun ExceptionHandlingSelectionDemo(navController: NavHostController) {

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        Spacer(modifier = Modifier.height(20.dp))

        AppButton(text = "Using Launch") {
            navController.navigate(ModuleDemo.UsingLaunchExceptionHandleDemo.rout)

        }

        Spacer(modifier = Modifier.height(20.dp))

        AppButton(text = "Using Async") {
            navController.navigate(ModuleDemo.UsingAsyncExceptionHandleDemo.rout)

        }
    }

}