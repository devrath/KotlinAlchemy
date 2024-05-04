package com.istudio.app.modules.module_demos.flows.modules.collect_as_state_with_lifecycle

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
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CollectAsStateWithLifeCycleVm @Inject constructor(
    @ApplicationContext private val context: Context,
) : ViewModel() {

    companion object {
        const val INITIAL_VALUE = 0
    }

    private var currentTime = INITIAL_VALUE

    private val _data = MutableStateFlow(0)
    val data = _data.asStateFlow()


    init {
        initiate()
    }

    private fun initiate() {
        viewModelScope.launch {
            while(true){
                delay(1000L)
                println("Flow is active current time ---> $currentTime")
                _data.emit(currentTime++)
            }
        }
    }

    val newTimer = flow {
        while(true){
            delay(1000L)
            println("Flow is active current time ---> $currentTime")
            emit(currentTime++)
        }
    }.stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000L),0)

}