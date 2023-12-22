package com.istudio.app.modules.module_demos.higher_order_functions.ui

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
fun HigherOrderFunctionDemo(navController: NavHostController) {

    val viewModel: HigherOrderFunctionDemoVm = hiltViewModel()

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {


        Spacer(modifier = Modifier.height(16.dp))

        AppButton(text = "Passing Functions as parameter", onClick = {
            // Here will will calculate the square of a number
            val input = 5
            // Call the functionality
            val result = viewModel.performOperation(input) { input ->
                input * input
            }
            println(result)
        })

        Spacer(modifier = Modifier.height(16.dp))

        AppButton(text = "Returning Function", onClick = {
            // We pass a operation here
            val addFunction = viewModel.createCalculator("add")
            // We use the operation passed above to pass values for it
            val resultAdd = addFunction(5, 3) // Result is 8
            println("Result (Add): $resultAdd")
        })
    }


}