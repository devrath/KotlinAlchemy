package com.istudio.app.modules.module_demos.flows.modules.flow_basics.data

import android.util.Log
import com.istudio.app.data.mock.FlowMockApi
import com.istudio.app.data.mock.Stock
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

interface StockPriceDataSource {
    val latestStockList: Flow<List<Stock>>
}

class NetworkStockPriceDataSource(mockApi: FlowMockApi) : StockPriceDataSource {

    override val latestStockList: Flow<List<Stock>> = flow {
        // Periodically call the API in a never ending loop
        while (true) {
            // Fetch the data from mock data
            val currentStockList = mockApi.getCurrentStockPrices()
            // Emit the new set of mock elements
            emit(currentStockList)
            // Keep a delay of 5 seconds on each emission
            delay(5_000)
        }
    }
}