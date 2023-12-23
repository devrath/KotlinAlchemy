package com.istudio.app.modules.module_demos.channels

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.istudio.app.ui.composables.AppButton
import com.istudio.app.ui.composables.AppText

@Composable
fun ChannelsDemo(navController: NavHostController) {

    val viewModel: ChannelsDemoVm = hiltViewModel()

    val scrollState = rememberScrollState()

    Column(
        modifier = Modifier
            .verticalScroll(state = scrollState)
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        // <! ------------------- COMMUNICATING BETWEEN COROUTINES ------------------->
        AppText(text = "Basics")

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
            viewModel.usingProduce()
        })
        Spacer(modifier = Modifier.height(20.dp))
        // <! ------------------- COMMUNICATING BETWEEN COROUTINES ------------------->

        // <! ------------------- USING CHANNELS - BUFFERED -------------------------->
        AppText(text = "Channel Types")

        Spacer(modifier = Modifier.height(16.dp))
        AppButton(text = "Channel - Buffered", onClick = {

        })
        Spacer(modifier = Modifier.height(16.dp))
        AppButton(text = "Channel - Conflated", onClick = {

        })
        Spacer(modifier = Modifier.height(16.dp))
        AppButton(text = "Channel - Rendezvous", onClick = {

        })
        Spacer(modifier = Modifier.height(16.dp))
        AppButton(text = "Channel - Unlimited", onClick = {

        })
        // <! ------------------- USING CHANNELS - BUFFERED -------------------------->

    }
}