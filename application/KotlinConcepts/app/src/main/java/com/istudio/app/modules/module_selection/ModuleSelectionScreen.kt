package com.istudio.app.modules.module_selection

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.istudio.app.ui.composables.AppButton

@Composable
fun ModuleSelectionScreen(navController: NavHostController) {
    Column(
        modifier = Modifier.fillMaxSize().padding(10.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {

        Spacer(modifier = Modifier.height(16.dp))

        AppButton(text = "Kotlin Basics", onClick = {
            navController.navigate(ModuleDemo.KotlinBasicsDemo.rout)
        })

        Spacer(modifier = Modifier.height(16.dp))

        AppButton(text = "Sealed Class", onClick = {
            navController.navigate(ModuleDemo.SealedClassDemo.rout)
        })

        Spacer(modifier = Modifier.height(16.dp))

        AppButton(text = "Annotations in kotlin", onClick = {
            navController.navigate(ModuleDemo.AnnotationsInKotlin.rout)
        })

        Spacer(modifier = Modifier.height(16.dp))

        AppButton(text = "Type Alias", onClick = {
            navController.navigate(ModuleDemo.TypeAlias.rout)
        })

        Spacer(modifier = Modifier.height(16.dp))

        AppButton(text = "Higher Order Functions", onClick = {
            navController.navigate(ModuleDemo.HigherOrderFunctions.rout)
        })

        Spacer(modifier = Modifier.height(16.dp))

        AppButton(text = "NestedVsInner", onClick = {
            navController.navigate(ModuleDemo.NestedVsInner.rout)
        })

        Spacer(modifier = Modifier.height(16.dp))

        AppButton(text = "Channels", onClick = {
            navController.navigate(ModuleDemo.ChannelsDemo.rout)
        })

        Spacer(modifier = Modifier.height(16.dp))

        AppButton(text = "Flows", onClick = {
            navController.navigate(ModuleDemo.FlowsSelection.rout)
        })

    }
}