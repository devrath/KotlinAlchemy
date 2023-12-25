package com.istudio.app.modules.module_demos.flows.modules.terminal_operators

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.firstOrNull
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.lastOrNull
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.single
import kotlinx.coroutines.flow.singleOrNull
import kotlinx.coroutines.flow.toList
import kotlinx.coroutines.flow.toSet
import kotlinx.coroutines.launch
import javax.inject.Inject
import kotlin.coroutines.EmptyCoroutineContext

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

    /**
     * Terminal Operator: Last
     */
    fun demoLast() {
        viewModelScope.launch {
            val result = terminalOperatorDemo.lastOrNull()
            println("Result:-> $result")
        }
    }

    /**
     * Terminal Operator: Single
     */
    fun single() {
        viewModelScope.launch {
            val result = terminalOperatorDemo.singleOrNull()
            println("Result:-> $result")
        }
    }

    /**
     * Terminal Operator: ToListAndToSet
     */
    fun toListAndToSet() {
        viewModelScope.launch {
            val resultList = terminalOperatorDemo.toList()
            val resultSet = terminalOperatorDemo.toSet()
            println("Result List:-> $resultList")
            println("Result Set:-> $resultSet")
        }
    }

    /**
     * Terminal Operator: LaunchIn
     */
    fun launchIn() {

        val scope = CoroutineScope(EmptyCoroutineContext)

        viewModelScope.launch {
            terminalOperatorDemo
                .onEach { println("Result Collect <1>:-> $it") }
                .launchIn(scope)

            terminalOperatorDemo
                .onEach { println("Result Collect <2>:-> $it") }
                .launchIn(scope)
        }

    }

    fun launch() {

        val scope = CoroutineScope(EmptyCoroutineContext)

        scope.launch {

            // Collect -> Starting first collection
            terminalOperatorDemo.collect{
                println("Result Collect <1>:-> $it")
            }

            // <--- Until first collection is complete, collection is suspended --->

            // Collect -> Starting second collection
            terminalOperatorDemo.collect{
                println("Result Collect <2>:-> $it")
            }

        }

    }
    /** *********************** DEMO's *********************** **/
}