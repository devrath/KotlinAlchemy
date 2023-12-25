package com.istudio.app.modules.module_demos.flows.modules.terminal_operators

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.firstOrNull
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.lastOrNull
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TerminalOperatorsVm @Inject constructor(
    @ApplicationContext private val context: Context,
) : ViewModel() {
    companion object {
        const val emissionDelay : Long = 100
    }

    private val terminalOperatorDemo = flow <Int>{
        delay(emissionDelay)
        println("Emitting first value")
        emit(1)
        delay(emissionDelay)
        println("Emitting second value")
        emit(2)
    }

    /** *********************** DEMO's *********************** **/
    /**
     * Terminal Operator: First
     */
    fun demoFirst() {
        viewModelScope.launch {
            val result = terminalOperatorDemo.firstOrNull()
            println("Result:-> $result")
        }
    }

    fun demoLast() {
        viewModelScope.launch {
            val result = terminalOperatorDemo.lastOrNull()
            println("Result:-> $result")
        }
    }

    /** *********************** DEMO's *********************** **/
}