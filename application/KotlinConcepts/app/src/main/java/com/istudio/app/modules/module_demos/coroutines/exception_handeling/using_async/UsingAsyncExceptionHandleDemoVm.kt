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
            val deferredResult = async(handler) {
                // Call the function that performs the asynchronous task
                performAsyncTask()
            }

            try {
                // Wait for the result of the async task
                val result = deferredResult.await()
                println("Async task result: $result")
            } catch (e: Exception) {
                // Exception will be caught by the exception handler
                println("Exception caught in main: $e")
            }
        }
    }

    private suspend fun performAsyncTask(): String {
        // Simulate some asynchronous work
        delay(1000)

        // Simulate an exception
        throw RuntimeException("Simulated exception in async task")
    }
    // <----------------------->   Using Exception Handler   <------------------->

}