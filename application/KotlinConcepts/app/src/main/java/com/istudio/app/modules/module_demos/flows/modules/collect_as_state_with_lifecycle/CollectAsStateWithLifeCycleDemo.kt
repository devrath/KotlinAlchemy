package com.istudio.app.modules.module_demos.flows.modules.collect_as_state_with_lifecycle

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavHostController
import com.istudio.app.ui.composables.AppButton
import kotlinx.coroutines.launch

@Composable
fun CollectAsStateWithLifeCycleDemo(navController: NavHostController){

    val viewModel: CollectAsStateWithLifeCycleVm = hiltViewModel()
    //val time = viewModel.data.collectAsStateWithLifecycle()
    //val time = viewModel.newTimer.collectAsStateWithLifecycle()
    val time: Int by viewModel.data.collectAsStateWithLifecycle()
    
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = time.toString(),
            fontSize = 30.sp
        )

    }


}