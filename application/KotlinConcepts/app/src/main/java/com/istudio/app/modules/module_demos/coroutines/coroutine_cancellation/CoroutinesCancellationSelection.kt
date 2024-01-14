package com.istudio.app.modules.module_demos.coroutines.coroutine_cancellation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.istudio.app.modules.module_selection.ModuleDemo
import com.istudio.app.ui.composables.AppButton

@Composable
fun CoroutinesCancellationSelection(navController: NavController){

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        Spacer(modifier = Modifier.height(16.dp))

        AppButton(text = "Root Children Cancel Demo", onClick = {
            navController.navigate(ModuleDemo.RootChildrenCancelDemo.rout)
        })

        Spacer(modifier = Modifier.height(16.dp))

        AppButton(text = "Is Active Demo", onClick = {
            navController.navigate(ModuleDemo.CoroutinesCancellationIsActiveDemo.rout)
        })


    }

}