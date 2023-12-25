package com.istudio.app.modules.module_demos.flows.modules.flow_basics.chapters.display_data_from_server

import android.content.Context
import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.istudio.app.modules.module_demos.flows.modules.flow_basics.data.StockData
import com.istudio.app.modules.module_demos.flows.modules.flow_basics.state.UiError
import com.istudio.app.modules.module_demos.flows.modules.flow_basics.state.UiState
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onCompletion
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DisplayDataFromServerVm @Inject constructor(
    @ApplicationContext private val context: Context,
) : ViewModel() {

    var viewState: MutableState<UiState> = mutableStateOf(UiState())

    fun getDataFromServerUsingCollect() {
        viewModelScope.launch {
            StockData.getData(context)
                .map { stockList ->
                    // We converted data from one form to another - Here UiState
                    viewState.value = viewState.value.copy(
                        error = UiError(errorMessage =  "", isError = false),
                        stockList = stockList
                    )
                }.onStart {
                    // We indicate the UI will start loading
                    viewState.value = viewState.value.copy(
                        error = UiError(errorMessage =  "", isError = false),
                        isLoading = true
                    )
                }.catch { error ->
                    // Emit the error if the error is found
                    viewState.value = viewState.value.copy(
                        error = UiError(errorMessage =  error.localizedMessage, isError = true)
                    )
                }.onCompletion {
                    // This indicates flow is completed
                    Log.d("Flow","Flow has completed.")
                    viewState.value = viewState.value.copy(
                        error = UiError(errorMessage =  "", isError = false),
                        isLoading = false
                    )
                }.collect()
        }
    }



    fun getDataFromServerUsingLaunchIn() {
        viewModelScope.launch {
            StockData.getData(context)
                .onEach { stockList ->
                    // We converted data from one form to another - Here UiState
                    viewState.value = viewState.value.copy(
                        error = UiError(errorMessage =  "", isError = false),
                        stockList = stockList
                    )
                }.onStart {
                    // We indicate the UI will start loading
                    viewState.value = viewState.value.copy(
                        error = UiError(errorMessage =  "", isError = false),
                        isLoading = true
                    )
                }.catch { error ->
                    // Emit the error if the error is found
                    viewState.value = viewState.value.copy(
                        error = UiError(errorMessage =  error.localizedMessage, isError = true)
                    )
                }.onCompletion {
                    // This indicates flow is completed
                    Log.d("Flow","Flow has completed.")
                    viewState.value = viewState.value.copy(
                        error = UiError(errorMessage =  "", isError = false),
                        isLoading = false
                    )
                }.launchIn(viewModelScope)
        }
    }

}