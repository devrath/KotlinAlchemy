package com.istudio.app.modules.module_demos.flows.modules.flow_basics.ui

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
import com.istudio.app.modules.module_selection.ModuleDemo
import com.istudio.app.ui.composables.AppButton
import com.istudio.app.ui.composables.AppText

@Composable
fun FlowBasics(navController: NavHostController){

    val viewModel: FlowBasicsVm = hiltViewModel()

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        Spacer(modifier = Modifier.height(16.dp))

        AppButton(text = "Flow Builders", onClick = {
            viewModel.flowBuilders()
        })

    }


}