package com.istudio.app.modules.module_demos.flows.modules.flatten_flows

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.CoroutineName
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.firstOrNull
import kotlinx.coroutines.flow.flatMapConcat
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.flow.flatMapMerge
import kotlinx.coroutines.flow.flattenConcat
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.lastOrNull
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.singleOrNull
import kotlinx.coroutines.flow.take
import kotlinx.coroutines.flow.toList
import kotlinx.coroutines.flow.toSet
import kotlinx.coroutines.launch
import javax.inject.Inject
import kotlin.coroutines.EmptyCoroutineContext

@HiltViewModel
class FlattenFlowsDemoVm @Inject constructor(
    @ApplicationContext private val context: Context,
) : ViewModel() {

    private val rootScope = CoroutineScope(context = Dispatchers.IO)

    /**
     * Flow of integers
     */
    fun generateIntegers() = flow {
        repeat(100){
            delay(1000)
            emit(it)
        }
    }


    /**
     * Generate a flow of strings
     */
    fun generateFlowOfStrings(value : Int) = flow {
        val content = "Current string no -->$value at the thread${Thread.currentThread().name}"
        println("<Emitted> -->$value")
        emit(content)
    }


    fun flatMapConcat() = rootScope.launch(CoroutineName("FlatMapConcatDemo")){

       // Way-1
       /* val result : Flow<Flow<String>> = generateIntegers()
           .take(5)
           .map {
               generateFlowOfStrings(it)
           }

        result.flattenConcat().collect{
            println(it)
        }*/


        //Way-2
        generateIntegers()
            .take(5)
            .flatMapConcat {
                generateFlowOfStrings(it)
            }.collect{
                println(it)
            }

    }



    fun flatMapMerge() = rootScope.launch(CoroutineName("flatMapMerge")){

        generateIntegers()
            .take(5)
            .flatMapMerge() {
                generateFlowOfStrings(it)
            }.collect{
                println(it)
            }

    }

    fun flatMaplatest() = rootScope.launch(CoroutineName("flatMapLatest")){
        generateIntegers()
            .take(5)
            .flatMapLatest {
                generateFlowOfStrings(it)
            }.collect{
                println("collected: ---> $it")
            }
    }

}