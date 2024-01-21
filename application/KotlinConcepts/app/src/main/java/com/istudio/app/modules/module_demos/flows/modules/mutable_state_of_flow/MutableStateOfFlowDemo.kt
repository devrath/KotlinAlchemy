package com.istudio.app.modules.module_demos.flows.modules.mutable_state_of_flow

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.istudio.app.ui.composables.AppButton
import com.istudio.app.ui.composables.AppText
import kotlinx.coroutines.launch

@Composable
fun MutableStateOfFlowDemo(navController: NavHostController){

    val viewModel: MutableStateOfFlowDemoVm = hiltViewModel()

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        val coroutineScope = rememberCoroutineScope()

        Spacer(modifier = Modifier.height(16.dp))

        AppButton(text = "Start producing emissions", onClick = {
            coroutineScope.launch {
                repeat(100){
                    viewModel.produce(it)
                }
            }
        })

        Spacer(modifier = Modifier.height(10.dp))

        LaunchedEffect(key1 = true){
            coroutineScope.launch {
                viewModel.data.collect{
                    println("Consumed -> $it")
                }
            }
        }

    }


}