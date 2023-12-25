package com.istudio.app.modules.module_demos.flows.modules.flow_basics.chapters.display_data_from_server

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.rememberLazyGridState
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.istudio.app.modules.module_demos.flows.modules.flow_basics.chapters.display_data_from_server.composables.StockItem
import com.istudio.app.modules.module_demos.flows.modules.flow_basics.state.UiState
import com.istudio.app.modules.module_demos.flows.modules.flow_basics.ui.FlowBasicsVm
import com.istudio.app.ui.composables.AppButton

@Composable
fun DisplayDataFromServerDemo(navController: NavHostController){

    // <!------------ MAIN-COMPOSE-CONTROL-PARTS ----------------->
    // View model reference
    val viewModel: DisplayDataFromServerVm = hiltViewModel()
    // View state reference from view model
    val state = viewModel.viewState
    // <!------------ MAIN-COMPOSE-CONTROL-PARTS ----------------->

    // LaunchedEffect will run the provided block when the composition is first committed
    LaunchedEffect(true){
        viewModel.getDataFromServer()
    }

    when (state.value) {
        is UiState.Loading -> {
            // Display a loading indicator
            Text(text = "Loading...")
        }
        is UiState.Success -> {
            // Display the lazy list with stock data
            val dataList = (state.value as UiState.Success).stockList
            LazyColumn(
                modifier = Modifier.background(color = MaterialTheme.colorScheme.background),
                state = rememberLazyListState(),
                content = {
                    items(dataList.size){ i ->
                        StockItem(data = dataList[i])
                    }
                }
            )
        }
        is UiState.Error -> {
            // Display an error message
            val message = (state.value as UiState.Error).message
            Text(text = "Error: $message")
        }
    }

}