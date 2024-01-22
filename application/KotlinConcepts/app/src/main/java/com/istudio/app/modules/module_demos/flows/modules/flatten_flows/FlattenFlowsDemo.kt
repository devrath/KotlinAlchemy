package com.istudio.app.modules.module_demos.flows.modules.flatten_flows

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
fun FlattenFlowsDemo(navController: NavHostController){

    val viewModel: FlattenFlowsDemoVm = hiltViewModel()

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        Spacer(modifier = Modifier.height(16.dp))

        AppText(text = "Terminal Operators")

        Spacer(modifier = Modifier.height(16.dp))

        AppButton(text = "First", onClick = { viewModel.demoFirst() })

        Spacer(modifier = Modifier.height(16.dp))

        AppButton(text = "Last", onClick = { viewModel.demoLast() })

        Spacer(modifier = Modifier.height(16.dp))

        AppButton(text = "Single", onClick = { viewModel.single() })

        Spacer(modifier = Modifier.height(16.dp))

        AppButton(text = "ToList And ToSet", onClick = { viewModel.toListAndToSet() })

        Spacer(modifier = Modifier.height(16.dp))

        AppButton(text = "LaunchIn", onClick = { viewModel.launchIn() })

    }


}