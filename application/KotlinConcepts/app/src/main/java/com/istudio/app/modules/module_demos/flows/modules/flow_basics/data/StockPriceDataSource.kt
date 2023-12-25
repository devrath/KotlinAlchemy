package com.istudio.app.modules.module_demos.flows.modules.flow_basics.data

import android.util.Log
import com.istudio.app.data.mock.FlowMockApi
import com.istudio.app.data.mock.Stock
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.flow

interface StockPriceDataSource {
    suspend fun getLatestStockList() : Flow<List<Stock>>
}

class NetworkStockPriceDataSource(val mockApi: FlowMockApi) : StockPriceDataSource {
    override suspend fun getLatestStockList(): Flow<List<Stock>>  = flow {
        emit(mockApi.getCurrentStockPrices())
    }
}