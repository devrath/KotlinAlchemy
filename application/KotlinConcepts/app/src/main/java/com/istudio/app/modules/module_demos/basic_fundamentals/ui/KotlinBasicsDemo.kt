package com.istudio.app.modules.module_demos.basic_fundamentals.ui

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
fun KotlinBasicsDemo(navController: NavHostController) {

    val viewModel: KotlinBasicsDemoVm = hiltViewModel()

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {


        Spacer(modifier = Modifier.height(16.dp))

        AppButton(text = "Strings in kotlin", onClick = {
            //viewModel.jvmFieldDemo()
        })

        Spacer(modifier = Modifier.height(16.dp))

        AppButton(text = "Comparison operators", onClick = {
            //viewModel.jvmFieldDemo()
        })

        Spacer(modifier = Modifier.height(16.dp))

        AppButton(text = "Scope in kotlin", onClick = {
            //viewModel.jvmFieldDemo()
        })

        Spacer(modifier = Modifier.height(16.dp))

        AppButton(text = "Large tree in conditions", onClick = {
            //viewModel.jvmFieldDemo()
        })

        Spacer(modifier = Modifier.height(16.dp))

        AppButton(text = "Defining & using nullable", onClick = {
            //viewModel.jvmFieldDemo()
        })

        Spacer(modifier = Modifier.height(16.dp))

        AppButton(text = "Pairs & Triplets", onClick = {
            //viewModel.jvmFieldDemo()
        })

        Spacer(modifier = Modifier.height(16.dp))

        AppButton(text = "Pairs & Triplets", onClick = {
            //viewModel.jvmFieldDemo()
        })

        Spacer(modifier = Modifier.height(16.dp))

        AppButton(text = "Arrays in kotlin", onClick = {
            //viewModel.jvmFieldDemo()
        })

        Spacer(modifier = Modifier.height(16.dp))

        AppButton(text = "List in kotlin", onClick = {
            //viewModel.jvmFieldDemo()
        })

        Spacer(modifier = Modifier.height(16.dp))

        AppButton(text = "Map in kotlin", onClick = {
            //viewModel.jvmFieldDemo()
        })

        Spacer(modifier = Modifier.height(16.dp))

        AppButton(text = "Set in kotlin", onClick = {
            //viewModel.jvmFieldDemo()
        })

        Spacer(modifier = Modifier.height(16.dp))

        AppButton(text = "Looping Mechanisms", onClick = {
            //viewModel.jvmFieldDemo()
        })

        Spacer(modifier = Modifier.height(16.dp))

        AppButton(text = "Custom Accessors", onClick = {
            //viewModel.jvmFieldDemo()
        })

        Spacer(modifier = Modifier.height(16.dp))

        AppButton(text = "Delegated properties", onClick = {
            //viewModel.jvmFieldDemo()
        })

        Spacer(modifier = Modifier.height(16.dp))

        AppButton(text = "Enum in kotlin", onClick = {
            //viewModel.jvmFieldDemo()
        })

    }

}