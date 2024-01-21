package com.istudio.app.modules.module_demos.flows.modules.state_and_shared_flows

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
import com.istudio.app.ui.composables.AppText

@Composable
fun StateAndSharedFlowDemo(navController: NavHostController){

    val viewModel: StateAndSharedFlowsDemoVm = hiltViewModel()

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        Spacer(modifier = Modifier.height(16.dp))

        AppText(text = "Using Shared-In\nto convert into Hot-Flow")

        Spacer(modifier = Modifier.height(16.dp))

        AppButton(text = "First subscription", onClick = { viewModel.demo() })
        Spacer(modifier = Modifier.height(10.dp))
        AppButton(text = "Add second subscription", onClick = { viewModel.addNewSubscriber() })

    }


}