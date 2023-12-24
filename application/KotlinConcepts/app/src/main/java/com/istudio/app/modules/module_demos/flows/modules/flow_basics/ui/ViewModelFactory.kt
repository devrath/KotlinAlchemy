package com.istudio.app.modules.module_demos.flows.modules.flow_basics.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.istudio.app.modules.module_demos.flows.modules.flow_basics.data.StockPriceDataSource

class ViewModelFactory(private val stockPriceDataSource: StockPriceDataSource) :
    ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return modelClass.getConstructor(StockPriceDataSource::class.java)
            .newInstance(stockPriceDataSource)
    }
}