package com.istudio.app.modules.module_demos.coroutines.compare_join_and_async

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.CoroutineName
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

class CompareJoinAsyncDemoVm @Inject constructor( ) : ViewModel() {

    private val scopeJob = Job()

    private val ourScope =  CoroutineScope(scopeJob + Dispatchers.Default)

    fun demo() {
        try {
            ourScope.launch(CoroutineName("GrandParent")) {
                try {
                    parent1Block().join()
                    parent2Block().join()
                    println("Both parent code blocks are completed")
                }catch (ex:Exception){
                    println("Exception caught inside GrandParent scope")
                }
            }.invokeOnCompletion {
                println("GrandParent invokeOnCompletion triggered")
            }
        }catch (ex:Exception){
            println("Exception caught outside GrandParent scope")
        }
    }


    private suspend fun parent1Block() = ourScope.launch(CoroutineName("Parent-1")) {
        try {
            repeat(10){
                println("Parent-1 ----- tick ----->$it")
                delay(1000)
            }
        }catch (ex:Exception){
            println("Exception caught inside Parent-1 coroutine")
        }
    }

    private suspend fun parent2Block() = ourScope.launch(CoroutineName("Parent-2")) {
        try {
            parent2Child1Block().join()
            println("Parent-2-Child-1 block is completed")
            repeat(10){
                println("Parent-2-Child-1 ----- tick ----->$it")
                delay(1000)
            }
        }catch (ex:Exception){
            println("Exception caught inside Parent-2 coroutine")
        }
    }

    private suspend fun parent2Child1Block() = ourScope.launch(CoroutineName("Parent-2-Child-1")) {
        try {
            repeat(10){
                println("Parent-2-Child-1 ----- tick ----->$it")
                delay(1000)
            }
        }catch (ex:Exception){
            println("Exception caught inside Parent-2-Child-1 coroutine")
        }
    }


    fun rootCancel() {
        scopeJob?.cancel()
    }

}