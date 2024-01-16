package com.istudio.app.modules.module_demos.coroutines.exception_handeling.using_async

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.CoroutineName
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

class UsingAsyncExceptionHandleDemoVm @Inject constructor( ) : ViewModel() {

    private val scopeJob = Job()

    private val ourScope =  CoroutineScope(scopeJob + Dispatchers.Default)

    fun demo() {
        try {
            ourScope.launch(CoroutineName("GrandParent")) {
                try {
                    parent1Block()
                    parent2Block()
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


    private fun parent1Block(){
        try {
            ourScope.launch(CoroutineName("Parent-1")) {
                try {
                    parent1Child1Block()
                    parent1Child2Block()
                }catch (ex:Exception){
                    println("Exception caught inside Parent-1 scope")
                }
            }.invokeOnCompletion {
                println("Parent-1 invokeOnCompletion triggered")
            }
        }catch (ex:Exception){
            println("Exception caught outside Parent-1 scope")
        }
    }
    private fun parent2Block(){
        try {
            ourScope.launch(CoroutineName("Parent-2")) {
                try {
                    parent2Child1Block()
                    parent2Child2Block()
                }catch (ex:Exception){
                    println("Exception caught inside Parent-2 scope")
                }
            }.invokeOnCompletion {
                println("Parent-2 invokeOnCompletion triggered")
            }
        }catch (ex:Exception){
            println("Exception caught outside Parent-2 scope")
        }
    }
    private fun parent1Child1Block(){
        try {
            ourScope.launch(CoroutineName("Parent-1-child-1")) {
                try {
                    repeat(10){
                        println("Parent-1-child-1 ------------------>$it")
                        delay(1000)
                    }
                }catch (ex:Exception){
                    println("Exception caught inside Parent-1-child-1 scope")
                }
            }.invokeOnCompletion {
                println("Parent-1-child-1 invokeOnCompletion triggered")
            }
        }catch (ex:Exception){
            println("Exception caught outside Parent-1-child-1 scope")
        }
    }
    private fun parent1Child2Block(){
        try {
            ourScope.launch(CoroutineName("Parent-1-child-2")) {
                try {
                    repeat(10){
                        println("Parent-1-child-2 ------------------>$it")
                        delay(1000)
                    }
                }catch (ex:Exception){
                    println("Exception caught inside Parent-1-child-2 scope")
                }
            }.invokeOnCompletion {
                println("Parent-1-child-2 invokeOnCompletion triggered")
            }
        }catch (ex:Exception){
            println("Exception caught outside Parent-1-child-2 scope")
        }
    }
    private fun parent2Child1Block(){
        try {
            ourScope.launch(CoroutineName("Parent-2-child-1")) {
                try {
                    repeat(10){
                        println("Parent-2-child-1 ------------------>$it")
                        delay(1000)
                    }
                }catch (ex:Exception){
                    println("Exception caught inside Parent-2-child-1 scope")
                }
            }.invokeOnCompletion {
                println("Parent-2-child-1 invokeOnCompletion triggered")
            }
        }catch (ex:Exception){
            println("Exception caught outside Parent-2-child-1 scope")
        }
    }
    private fun parent2Child2Block(){
        try {
            ourScope.launch(CoroutineName("Parent-2-child-2")) {
                try {
                    repeat(10){
                        println("Parent-2-child-2 ------------------>$it")
                        delay(1000)
                    }
                }catch (ex:Exception){
                    println("Exception caught inside Parent-2-child-2 scope")
                }
            }.invokeOnCompletion {
                println("Parent-2-child-2 invokeOnCompletion triggered")
            }
        }catch (ex:Exception){
            println("Exception caught outside Parent-2-child-2 scope")
        }
    }

    fun rootCancel() {
        scopeJob?.cancel()
    }

}