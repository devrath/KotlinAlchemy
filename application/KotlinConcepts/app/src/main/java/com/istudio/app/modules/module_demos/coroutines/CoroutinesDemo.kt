package com.istudio.app.modules.module_demos.coroutines

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
import androidx.navigation.NavController
import com.istudio.app.modules.module_selection.ModuleDemo
import com.istudio.app.ui.composables.AppButton

@Composable
fun CoroutinesDemo(navController: NavController){

    val viewModel: CoroutinesDemoVm = hiltViewModel()

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        Spacer(modifier = Modifier.height(16.dp))

        AppButton(text = "Create a Coroutine scope", onClick = {
            viewModel.createCoroutineScopeDemo()
        })

        Spacer(modifier = Modifier.height(16.dp))

        AppButton(text = "Wait for coroutine to finish", onClick = {
            viewModel.waitForCoRoutineToFinish()
        })

        Spacer(modifier = Modifier.height(16.dp))

        AppButton(text = "Sequential coroutines", onClick = {
            viewModel.sequentialCoroutiens()
        })

        Spacer(modifier = Modifier.height(16.dp))

        AppButton(text = "Scope and context relationship", onClick = {
            viewModel.scopeAndContextRelationshipDemo()
        })

        Spacer(modifier = Modifier.height(16.dp))

        AppButton(text = "Simple structured concurrency", onClick = {
            navController.navigate(ModuleDemo.SimpleStructuredConcurrencyDemo.rout)
        })

        Spacer(modifier = Modifier.height(16.dp))

        AppButton(text = "Dispatchers Demo", onClick = {
            navController.navigate(ModuleDemo.DispatchersDemo.rout)
        })

        Spacer(modifier = Modifier.height(16.dp))

        AppButton(text = "Coroutine Cancellation Demos", onClick = {
            navController.navigate(ModuleDemo.CoroutinesCancellationSelection.rout)
        })

        Spacer(modifier = Modifier.height(16.dp))

        AppButton(text = "Suspend And Launch Demo", onClick = {
            navController.navigate(ModuleDemo.SuspendAndLaunchDemo.rout)
        })

        Spacer(modifier = Modifier.height(16.dp))

        AppButton(text = "Launch and with context demo", onClick = {
            navController.navigate(ModuleDemo.LaunchAndWithContextDemo.rout)
        })

        Spacer(modifier = Modifier.height(16.dp))

        AppButton(text = "Job Demos", onClick = {
            navController.navigate(ModuleDemo.JobDemoSelection.rout)
        })

        Spacer(modifier = Modifier.height(16.dp))

        AppButton(text = "Using Join Demo", onClick = {
            navController.navigate(ModuleDemo.UsingJoinDemo.rout)
        })

        Spacer(modifier = Modifier.height(16.dp))

        AppButton(text = "Using Async Await Demo", onClick = {
            navController.navigate(ModuleDemo.UsingAsyncAwaitDemo.rout)
        })

    }

}