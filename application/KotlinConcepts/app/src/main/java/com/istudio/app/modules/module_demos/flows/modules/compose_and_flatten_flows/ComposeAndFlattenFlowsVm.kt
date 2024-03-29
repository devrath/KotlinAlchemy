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
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.conflate
import kotlinx.coroutines.flow.firstOrNull
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.lastOrNull
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.singleOrNull
import kotlinx.coroutines.flow.take
import kotlinx.coroutines.flow.toList
import kotlinx.coroutines.flow.toSet
import kotlinx.coroutines.flow.zip
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

    /** *********************** Conflating *********************** **/
    private val conflatingDemoFlow = flow {
        // Make 10 emissions in iteration
        repeat(10){
            // Give some delay
            println("Emission -> $it")
            emit(it)
        }
    }.flowOn(Dispatchers.Default)

    fun conflating() = viewModelScope.launch{
        // It will show the time taken to execute this block of code
        val time = measureTimeMillis {
            conflatingDemoFlow.take(5).conflate().collect {
                delay(100)
                println("Collection -> $it")
            }
        }
        println("Time Taken:-> $time")
    }
    /** *********************** Conflating *********************** **/

    /** *********************** Collect Latest ******************* **/
    private val collectLatestDemoFlow = flow {
        // Make 10 emissions in iteration
        repeat(3){
            // Give some delay
            println("Emission -> $it")
            emit(it)
        }
    }.flowOn(Dispatchers.Default)

    fun collectLatest() = viewModelScope.launch{
        // It will show the time taken to execute this block of code
        val time = measureTimeMillis {
            collectLatestDemoFlow.collectLatest {
                println("Processing emission -> $it")
                delay(1000)
                println("Processed emission -> $it")
            }
        }
        println("Time Taken:-> $time")
    }
    /** *********************** Collect Latest ******************* **/

    /** *********************** Zipping ************************** **/
    private val flowOne = flow {
        emit("x")
        emit("y")
        emit("z")
    }.flowOn(Dispatchers.Default)

    private val flowTwo = flow {
        emit("x")
        emit("y")
        emit("z")
    }.flowOn(Dispatchers.Default)

    fun zipping() = viewModelScope.launch{
        // It will show the time taken to execute this block of code
        val time = measureTimeMillis {
            flowOne.zip(flowTwo){ one , two ->
                one+two
            }.collect{
                println("Result:-> $it")
            }
        }
        println("Time Taken:-> $time")
    }

    /** *********************** Zipping ************************** **/

    /** *********************** Combining ************************ **/
    private val flowCombineOne = flow {
        emit("x")
        delay(5000)
        emit("y")
        emit("z")
    }.flowOn(Dispatchers.Default)

    private val flowCombineTwo = flow {
        emit("x")
        emit("y")
        emit("z")
    }.flowOn(Dispatchers.Default)

    fun combining() = viewModelScope.launch{
        // It will show the time taken to execute this block of code
        val time = measureTimeMillis {
            flowCombineOne.combine(flowCombineTwo){ one , two ->
                one+two
            }.collect{
                println("Result:-> $it")
            }
        }
        println("Time Taken:-> $time")
    }
    /** *********************** Combining ************************ **/

}