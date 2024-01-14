package com.istudio.app.modules.module_demos.coroutines.suspend_and_launch_demo

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.NonCancellable
import kotlinx.coroutines.delay
import kotlinx.coroutines.ensureActive
import kotlinx.coroutines.isActive
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject
import kotlin.coroutines.cancellation.CancellationException
import kotlin.coroutines.coroutineContext

class NonCancellableDemoVm @Inject constructor( ) : ViewModel() {

    private var job: Job? = null


    fun startWithTreadSleep() {

        // Start a coroutine
        job = CoroutineScope(Dispatchers.IO).launch {
            launch {
                coRoutineOne(1)
            }
           launch {
               coRoutineOne(2)
           }
        }
    }

    private suspend fun coRoutineOne(coroutineNo: Int) {
        //withContext(NonCancellable){
            try {
                repeat(10) { index ->
                    //coroutineContext.ensureActive()

                    // Simulate some work
                    delay(500)

                    // Check if the coroutine has been canceled
                    if (!coroutineContext.isActive) {
                        println("Coroutine-No:$coroutineNo canceled at index $index")
                    }else{
                        // Continue with the main logic
                        println("Coroutine-No:$coroutineNo Working at index $index")
                    }
                }
                // Additional logic after the loop
                println("Coroutine-No:$coroutineNo completed")
            }
            catch (e: CancellationException) {
                // Handle cancellation-specific tasks
                println("Coroutine-No:$coroutineNo canceled")
            }
       // }
    }

    fun cancel(){
        job?.cancel()
    }



}