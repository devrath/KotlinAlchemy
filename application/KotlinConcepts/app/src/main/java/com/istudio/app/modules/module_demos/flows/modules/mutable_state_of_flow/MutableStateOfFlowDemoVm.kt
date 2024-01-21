package com.istudio.app.modules.module_demos.flows.modules.mutable_state_of_flow

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.shareIn
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MutableStateOfFlowDemoVm @Inject constructor(
    @ApplicationContext private val context: Context,
) : ViewModel() {

    private val _data = MutableSharedFlow<Int>(0)
    val data = _data.asSharedFlow()

    suspend fun produce(value : Int) {
        println("Emitted value -> $value")
        _data.emit(value)
    }

}