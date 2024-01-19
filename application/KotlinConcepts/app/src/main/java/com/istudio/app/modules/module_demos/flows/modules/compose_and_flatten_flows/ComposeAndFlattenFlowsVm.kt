package com.istudio.app.modules.module_demos.flows.modules.compose_and_flatten_flows

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.buffer
import kotlinx.coroutines.flow.firstOrNull
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.lastOrNull
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.singleOrNull
import kotlinx.coroutines.flow.toList
import kotlinx.coroutines.flow.toSet
import kotlinx.coroutines.launch
import javax.inject.Inject
import kotlin.coroutines.EmptyCoroutineContext
import kotlin.system.measureTimeMillis

@HiltViewModel
class ComposeAndFlattenFlowsVm @Inject constructor(
    @ApplicationContext private val context: Context,
) : ViewModel() {

    /** *********************** Buffering *********************** **/

    private val bufferDemoFlow = flow {
        // Make 10 emissions in iteration
        repeat(10){
            // Give some delay
            delay(50)
            println("Emission -> $it")
            emit(it)
        }
    }.flowOn(Dispatchers.Default)

    fun buffering() = viewModelScope.launch{
        // It will show the time taken to execute this block of code
        val time = measureTimeMillis {
            bufferDemoFlow.buffer(5).collect {
                delay(100)
                println("Collection -> $it")
            }
        }
        println("Time Taken:-> $time")
    }
    /** *********************** Buffering *********************** **/

}