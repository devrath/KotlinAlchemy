package com.istudio.app.modules.module_demos.basic_fundamentals.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.istudio.app.ui.composables.AppButton
import com.istudio.app.ui.composables.AppText

@Composable
fun KotlinBasicsDemo(navController: NavHostController) {

    val viewModel: KotlinBasicsDemoVm = hiltViewModel()

    val scrollState = rememberScrollState()

    Column(
        modifier = Modifier
            .verticalScroll(state = scrollState)
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {


        Spacer(modifier = Modifier.height(16.dp))

        AppButton(text = "Strings in kotlin", onClick = {
            viewModel.stringsInKotlin()
        })

        Spacer(modifier = Modifier.height(16.dp))

        AppButton(text = "Comparison operators", onClick = {
            viewModel.comparisionOperators()
        })

        Spacer(modifier = Modifier.height(16.dp))

        AppButton(text = "Large tree in conditions", onClick = {
            viewModel.largeTreeConditions()
        })

        Spacer(modifier = Modifier.height(16.dp))

        AppButton(text = "Defining & using nullable", onClick = {
            viewModel.definingAndUsingNullable()
        })

        Spacer(modifier = Modifier.height(16.dp))

        AppButton(text = "Pairs & Triplets", onClick = {
            viewModel.storingPairsAndTriplets()
        })

        Spacer(modifier = Modifier.height(16.dp))

        AppButton(text = "Arrays in kotlin", onClick = {
            viewModel.arraysInKotlin()
        })

        Spacer(modifier = Modifier.height(16.dp))

        AppButton(text = "List in kotlin", onClick = {
            viewModel.listInKotlin()
        })

        Spacer(modifier = Modifier.height(16.dp))

        AppButton(text = "Map in kotlin", onClick = {
            viewModel.mapInKotlin()
        })

        Spacer(modifier = Modifier.height(16.dp))

        AppButton(text = "Set in kotlin", onClick = {
            viewModel.setInKotlin()
        })

        Spacer(modifier = Modifier.height(16.dp))

        AppButton(text = "Custom Accessors", onClick = {
            viewModel.customAccessors()
        })

        Spacer(modifier = Modifier.height(16.dp))

        AppButton(text = "Enum in kotlin", onClick = {
            viewModel.enumInKotlin()
        })

        Spacer(modifier = Modifier.height(16.dp))

        AppButton(text = "Members are private by default", onClick = {
            viewModel.membersPrivateDemo()
        })

        Spacer(modifier = Modifier.height(16.dp))

        AppButton(text = "Init block significance", onClick = {
            viewModel.initBlockSignificanceDemo()
        })

        Spacer(modifier = Modifier.height(16.dp))

        AppText(text = "Constructors Demo")

        Spacer(modifier = Modifier.height(5.dp))

        AppButton(text = "Primary Constructor", onClick = {
            viewModel.primaryConstructorDemo()
        })

    }

}