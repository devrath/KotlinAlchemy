package com.istudio.app.modules.module_demos.sealed_class.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.istudio.app.modules.module_demos.sealed_class.utils.payment.Payment
import com.istudio.app.modules.module_selection.ModuleDemo
import com.istudio.app.ui.composables.AppButton

@Composable
fun SealedClassDemo(navController: NavHostController) {

    val viewModel: SealedClassDemoVm = hiltViewModel()

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        Spacer(modifier = Modifier.height(16.dp))

        AppButton(text = "Create Sealed class Object", onClick = {
            viewModel.createSealedClassObject()
        })

        Spacer(modifier = Modifier.height(16.dp))

        AppButton(text = "Access public members of sealed class", onClick = {
            viewModel.accessPublicMembers()
        })

        Spacer(modifier = Modifier.height(16.dp))

        AppButton(text = "Access public function of sealed class", onClick = {
            viewModel.accessPublicFunction()
        })

        Spacer(modifier = Modifier.height(16.dp))

        AppButton(text = "Replicating Enum function using sealed class", onClick = {
            viewModel.replicatingEnumFunction()
        })

        Spacer(modifier = Modifier.height(16.dp))

        AppButton(text = "Suggesting all possible options of state", onClick = {
            viewModel.suggestAllPossibleOptions(
                Payment.BankTransfer(amount = 10, orderId = 20)
            )
        })

        Spacer(modifier = Modifier.height(16.dp))

        AppButton(text = "Using Abstract variable", onClick = {
            viewModel.usingAbstractVariable()
        })

    }
}