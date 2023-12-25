package com.istudio.app.modules.module_demos.flows.modules.flow_basics.data

import android.content.Context
import com.istudio.app.data.mock.Stock
import com.istudio.app.modules.module_demos.flows.modules.flow_basics.data.api.mockApi
import kotlinx.coroutines.flow.Flow

object StockData {
    suspend fun getData(context : Context): Flow<List<Stock>> {
        return NetworkStockPriceDataSource(mockApi(context)).getLatestStockList()
    }

}