package com.istudio.app.modules.module_demos.flows

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController


@Composable
fun FlowsDemo (navController: NavHostController) {

    val viewModel: FlowsDemoVm = hiltViewModel()

}