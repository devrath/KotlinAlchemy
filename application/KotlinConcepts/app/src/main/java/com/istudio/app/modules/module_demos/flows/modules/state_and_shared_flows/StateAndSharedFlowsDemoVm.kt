package com.istudio.app.modules.module_demos.flows.modules.state_and_shared_flows

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.firstOrNull
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.lastOrNull
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.shareIn
import kotlinx.coroutines.flow.singleOrNull
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.toList
import kotlinx.coroutines.flow.toSet
import kotlinx.coroutines.launch
import javax.inject.Inject
import kotlin.coroutines.EmptyCoroutineContext

@HiltViewModel
class StateAndSharedFlowsDemoVm @Inject constructor(
    @ApplicationContext private val context: Context,
) : ViewModel() {

    /**
     * ********************************* SharedIn *********************************
     */
    // Cold Flow
    private fun generateDemoFlow() = flow {
        repeat(1000){
            emit("Emitting value => $it")
            delay(2000)
        }
    }.shareIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(),
        replay = 5
    )

    fun demo()  = viewModelScope.launch{
        // Give a delay of 1 second before subscribing
        delay(1000)

        generateDemoFlow().collect{
            println("Collected value (A) => $it")
        }
    }

    fun addNewSubscriber() = viewModelScope.launch{
        generateDemoFlow().collect{
            println("Collected value (B) => $it")
        }
    }
    /**
     * ********************************* SharedIn *********************************
     */


    /**
     * ********************************* StateIn *********************************
     */
    private suspend fun generateDemoFlowTwo() = flow {
        repeat(1000){
            emit("Emitting value => $it")
            delay(2000)
        }
    }.stateIn(
        scope = viewModelScope
    )

    fun demoTwo() = viewModelScope.launch {

        println("Before second subscriber subscription -> ${generateDemoFlowTwo().value}")

        // Give a delay of 1 second before subscribing
        delay(1000)

        generateDemoFlowTwo().collect{
            println("Collected value (A) => $it")
        }
    }

    fun addNewSubscriberDemoTwo() = viewModelScope.launch{
        generateDemoFlow().collect{
            println("Collected value (B) => $it")
        }
    }
    /**
     * ********************************* StateIn *********************************
     */

}