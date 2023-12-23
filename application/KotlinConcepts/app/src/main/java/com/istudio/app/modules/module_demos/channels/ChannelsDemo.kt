package com.istudio.app.modules.module_demos.channels

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
import com.istudio.app.ui.composables.AppButton

@Composable
fun ChannelsDemo(navController: NavHostController) {

    val viewModel: ChannelsDemoVm = hiltViewModel()

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Spacer(modifier = Modifier.height(16.dp))

        AppButton(text = "Simple Communication", onClick = {
            viewModel.simpleCommunication()
        })

        Spacer(modifier = Modifier.height(16.dp))

        AppButton(text = "Sending/Receiving multiple values", onClick = {
            viewModel.sendingMultipleValues()
        })

        Spacer(modifier = Modifier.height(16.dp))

        AppButton(text = "Canceling a channel", onClick = {
            viewModel.cancellingChannel()
        })

        Spacer(modifier = Modifier.height(16.dp))

        AppButton(text = "Closing a channel", onClick = {
            viewModel.closingChannel()
        })

        Spacer(modifier = Modifier.height(16.dp))

        AppButton(text = "Using Produce", onClick = {
            viewModel.closingChannel()
        })
    }
}