package com.istudio.app.modules.module_demos.coroutines.coroutine_cancellation.ensure_active_demo

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.currentCoroutineContext
import kotlinx.coroutines.delay
import kotlinx.coroutines.ensureActive
import kotlinx.coroutines.isActive
import kotlinx.coroutines.launch
import javax.inject.Inject
import kotlin.coroutines.cancellation.CancellationException

class EnsureActiveDemoVm @Inject constructor( ) : ViewModel() {

    private var job: Job? = null


    fun startWithThreadSleep() {
        job = CoroutineScope(Dispatchers.Default).launch {
            startSuspendWithThreadSleep()
        }
    }

    private suspend fun startSuspendWithThreadSleep() {
        try {

            repeat(10) { index ->
                currentCoroutineContext().ensureActive()
                // Simulate some work
                Thread.sleep(500)

                // Check if the coroutine has been canceled
                if (!currentCoroutineContext().isActive) {
                    println("Coroutine canceled at index $index")
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

    fun cancel(){
        job?.cancel()
    }



}