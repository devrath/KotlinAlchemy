package com.istudio.app.modules.module_demos.flows.modules.flow_basics.chapters.display_data_from_server

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.rememberLazyGridState
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.CircularProgressIndicator
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
    val stockList = viewModel.viewState.value.stockList
    val isLoading = viewModel.viewState.value.isLoading
    val error = viewModel.viewState.value.error
    // <!------------ MAIN-COMPOSE-CONTROL-PARTS ----------------->

    // LaunchedEffect will run the provided block when the composition is first committed
    LaunchedEffect(true){
        // This is called only once
        viewModel.getDataFromServer()
    }

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        if(isLoading){
            // Display a loading indicator
            CircularProgressIndicator(
                modifier = Modifier.width(64.dp),
                color = MaterialTheme.colorScheme.secondary,
                trackColor = MaterialTheme.colorScheme.surfaceVariant,
            )
        }else{
            // Either data is there or, there can be error
            if(!error.isError){
                // Error is not there ---> Display the data
                LazyColumn(
                    modifier = Modifier.background(color = MaterialTheme.colorScheme.background),
                    state = rememberLazyListState(),
                    contentPadding = PaddingValues(16.dp),
                    verticalArrangement = Arrangement.spacedBy(16.dp)
                ){
                    items(
                        count = stockList.size,
                        key = {
                            stockList[it].id
                        },
                        itemContent = {
                            StockItem(data = stockList[it])
                        }
                    )
                }
            }else{
                // Error is there
                Text(text = error.errorMessage)
            }
        }
    }

}