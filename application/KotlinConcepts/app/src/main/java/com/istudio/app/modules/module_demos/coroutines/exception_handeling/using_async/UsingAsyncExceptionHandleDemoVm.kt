package com.istudio.app.modules.module_demos.coroutines.exception_handeling.using_async

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.CoroutineName
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.async
import kotlinx.coroutines.awaitAll
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

class UsingAsyncExceptionHandleDemoVm @Inject constructor( ) : ViewModel() {

    private val scopeJob = Job()

    private val ourScope =  CoroutineScope(scopeJob + Dispatchers.Default)

    // <----------------------->   Using Exception Handler   <------------------->
    fun demo() {

        val handler = CoroutineExceptionHandler { _, exception ->
            println("Caught an exception: $exception")
        }
        viewModelScope.launch {
            ourScope.async(CoroutineName("Parent") + handler) {
                val child1 = ourScope.async (CoroutineName("Child-1")) {
                    delay(10000)
                }
                val child2 = ourScope.async(CoroutineName("Child-2")) {
                    throw RuntimeException("Child-2 throws exception")
                    delay(10000)
                }
                awaitAll(child1,child2)
                // Outer delay
                delay(15000)
            }.await()
        }
    }
    // <----------------------->   Using Exception Handler   <------------------->

}