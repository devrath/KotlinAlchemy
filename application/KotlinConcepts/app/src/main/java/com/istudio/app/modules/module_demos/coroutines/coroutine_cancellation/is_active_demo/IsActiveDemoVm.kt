package com.istudio.app.modules.module_demos.coroutines.coroutine_cancellation.is_active_demo

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.cancel
import kotlinx.coroutines.cancelChildren
import kotlinx.coroutines.delay
import kotlinx.coroutines.isActive
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject
import kotlin.coroutines.cancellation.CancellationException

class IsActiveDemoVm @Inject constructor( ) : ViewModel() {

    private var job: Job? = null


    fun startWithTreadSleep() {

        // Start a coroutine
        job = CoroutineScope(Dispatchers.Default).launch {
            try {
                repeat(5000) { index ->
                    // Simulate some work
                    Thread.sleep(500)

                    // Check if the coroutine has been canceled
                    if (!isActive) {
                        println("Coroutine canceled at index $index")
                        return@launch
                    }
                    // Continue with the main logic
                    println("Working at index $index")
                }
                // Additional logic after the loop
                println("Coroutine completed")
            } catch (e: CancellationException) {
                // Handle cancellation-specific tasks
                println("Coroutine canceled")
            }
        }
    }


    fun startWithDelay() {

        // Start a coroutine
        job = CoroutineScope(Dispatchers.Default).launch {
            try {
                repeat(5000) { index ->
                    // Simulate some work
                    delay(500)

                    // Check if the coroutine has been canceled
                    if (!isActive) {
                        println("Coroutine canceled at index $index")
                        return@launch
                    }
                    // Continue with the main logic
                    println("Working at index $index")
                }
                // Additional logic after the loop
                println("Coroutine completed")
            } catch (e: CancellationException) {
                // Handle cancellation-specific tasks
                println("Coroutine canceled")
            }
        }
    }

    fun cancel(){
        job?.cancel()
    }



}