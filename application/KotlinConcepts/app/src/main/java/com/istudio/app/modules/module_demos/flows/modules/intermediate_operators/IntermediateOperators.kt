package com.istudio.app.modules.module_demos.flows.modules.intermediate_operators

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
fun IntermediateOperators(navController: NavHostController) {

    val viewModel: IntermediateOperatorsVm = hiltViewModel()

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {

        Spacer(modifier = Modifier.height(16.dp))

        AppText(text = "Intermediate Operators")

        Spacer(modifier = Modifier.height(16.dp))

        AppButton(text = "Map Operator", onClick = { viewModel.mapOperator() })

        Spacer(modifier = Modifier.height(16.dp))

        AppButton(text = "Filter Operator", onClick = { viewModel.filterOperator() })

        Spacer(modifier = Modifier.height(16.dp))

        AppButton(text = "Take Operator", onClick = { viewModel.takeOperator() })

        Spacer(modifier = Modifier.height(16.dp))

        AppButton(text = "Drop Operator", onClick = { viewModel.dropOperator() })

        Spacer(modifier = Modifier.height(16.dp))

        AppButton(text = "Transform Operator", onClick = { viewModel.transformOperator() })

        
    }

}