package com.demo.code.modules.observabletypes

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.*

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

    fun flowDemo() {

    }

    fun sharedFlowDemo() {

    }


}