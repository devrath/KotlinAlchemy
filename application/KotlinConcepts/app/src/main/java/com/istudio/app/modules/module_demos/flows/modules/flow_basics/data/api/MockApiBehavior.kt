package com.istudio.app.modules.module_demos.flows.modules.flow_basics.data.api

import android.content.Context
import com.google.gson.Gson
import com.istudio.app.data.mock.MockNetworkInterceptor
import com.istudio.app.data.mock.createFlowMockApi
import com.istudio.app.data.mock.fakeCurrentStockPrices

fun mockApi(context: Context) =
    createFlowMockApi(
        MockNetworkInterceptor()
            .mock(
                path = "/current-stock-prices",
                body = { Gson().toJson(fakeCurrentStockPrices(context)) },
                status = 200,
                delayInMs = 1500,
            )
    )