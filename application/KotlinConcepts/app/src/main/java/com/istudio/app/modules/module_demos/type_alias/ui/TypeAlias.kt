package com.istudio.app.modules.module_demos.type_alias.ui

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
import com.istudio.app.modules.module_demos.kotlin_annotations.ui.KotlinAnnotationsDemoVm
import com.istudio.app.ui.composables.AppButton

@Composable
fun TypeAlias(navController: NavHostController) {

    val viewModel: TypeAliasVm = hiltViewModel()

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {


        AppButton(text = "Demo", onClick = {
            viewModel.demo()
        })


    }

}