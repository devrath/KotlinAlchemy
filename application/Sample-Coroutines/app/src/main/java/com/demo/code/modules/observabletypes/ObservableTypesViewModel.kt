package com.demo.code.modules.observabletypes

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

class ObservableTypesViewModel : ViewModel() {

    private val _liveData = MutableLiveData("Default")
    val liveData : LiveData<String> = _liveData

    private val _stateFlow = MutableStateFlow("Default")
    val stateFlow = _stateFlow.asStateFlow()

    private val _sharedFlow = MutableSharedFlow<String>()
    val sharedFlow = _sharedFlow.asSharedFlow()

    fun liveDataDemo() {
        _liveData.value = "Live Data"
    }

    fun stateFlowDemo() {
        _stateFlow.value = "State Flow"
    }

    fun flowDemo() : Flow<String>{
        return flow {
            emit("Flow")
        }
    }

    fun sharedFlowDemo() {
        viewModelScope.launch {
            _sharedFlow.emit("Shared Flow")
        }
    }


}