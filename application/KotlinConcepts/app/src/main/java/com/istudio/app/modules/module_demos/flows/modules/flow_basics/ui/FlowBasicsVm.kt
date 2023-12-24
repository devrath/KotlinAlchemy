package com.istudio.app.modules.module_demos.flows.modules.flow_basics.ui

import android.content.Context
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.istudio.app.modules.module_demos.flows.modules.flow_basics.data.StockData
import com.istudio.app.modules.module_demos.flows.modules.flow_basics.data.StockPriceDataSource
import com.istudio.app.modules.module_demos.flows.modules.flow_basics.state.UiState
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onCompletion
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FlowBasicsVm @Inject constructor(
    @ApplicationContext private val context: Context,
) : ViewModel() {
    fun flowBuilders() {
        viewModelScope.launch {

            // Builder: FlowOf ---> Just one value
            val demo1 = flowOf(10)
            // Builder: FlowOf ---> Multiple values
            val demo2 = flowOf("x","y","z")
            // Builder: AsFlow ---> Collections are converted to flow
            val demo3 = listOf("A","B","C").asFlow()
            // Builder: Emit
            val demo4 = flow<String> {
                emit("USA")
                delay(500)
                emit("INDIA")
            }

            println("<-------- Builder: FlowOf ---> Just one value -------->")
            demo1.collect{
                println(it)
            }
            println("<-------- Builder: FlowOf ---> Just one value -------->")
            println("<----------------------------------------------------->")
            println("<-------- Builder: FlowOf ---> Multiple one value ---->")
            demo2.collect{
                println(it)
            }
            println("<-------- Builder: FlowOf ---> Multiple one value ---->")
            println("<----------------------------------------------------->")
            println("<---------------- Builder: asFlow -------------------->")
            demo3.collect{
                println(it)
            }
            println("<---------------- Builder: asFlow -------------------->")
            println("<----------------------------------------------------->")
            println("<---------------- Builder: emit ---------------------->")
            demo4.collect{
                println(it)
            }
            println("<---------------- Builder: emit ---------------------->")

        }
    }


    val currentStockPriceAsLiveData: LiveData<UiState> = StockData.getData(context)
        .map { stockList ->
            UiState.Success(stockList) as UiState
        }
        .onStart {
            emit(UiState.Loading)
        }
        .onCompletion {
            Log.d("Flow","Flow has completed.")
        }
        .asLiveData()





}