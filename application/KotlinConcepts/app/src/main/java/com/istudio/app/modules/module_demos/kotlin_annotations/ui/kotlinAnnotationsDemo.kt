package com.istudio.app.modules.module_demos.kotlin_annotations.ui

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
fun KotlinAnnotationsDemo(navController: NavHostController) {

    val viewModel: KotlinAnnotationsDemoVm = hiltViewModel()

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {


        Spacer(modifier = Modifier.height(16.dp))

        AppButton(text = "@JvmField", onClick = {
            viewModel.jvmFieldDemo()
        })

        Spacer(modifier = Modifier.height(16.dp))

        AppButton(text = "@JvmOverloads", onClick = {
            viewModel.jvmOverloadsDemo()
        })

        Spacer(modifier = Modifier.height(16.dp))

        AppButton(text = "@JvmStatic", onClick = {
            viewModel.jvmStaticDemo()
        })

        Spacer(modifier = Modifier.height(16.dp))

        AppButton(text = "@StringRes", onClick = {
            viewModel.stringResDemo()
        })

    }

}