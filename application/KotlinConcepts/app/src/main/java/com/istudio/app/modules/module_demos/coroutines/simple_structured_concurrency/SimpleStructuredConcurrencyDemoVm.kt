package com.istudio.app.modules.module_demos.coroutines.simple_structured_concurrency

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.cancel
import kotlinx.coroutines.cancelChildren
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.util.concurrent.CancellationException
import javax.inject.Inject

class SimpleStructuredConcurrencyDemoVm @Inject constructor( ) : ViewModel() {

    // Create a root co-routine scope
    private val rootScope =  CoroutineScope(Dispatchers.Default)

    fun startNestedIndependentCoroutines() {
        // Launch a co-routine within the scope
        rootScope.launch {
            println("Start outer coroutine")

            // Create a nested co-routine scope
            val nestedScope =  CoroutineScope(Dispatchers.Default)

            // Launch a new co-routine within the nested scope
            nestedScope.launch {
                println("Start inner coroutine")
                delay(10000) // Observe we keep delay longer here than the outer delay
                println("End inner coroutine")
            }

            delay(5000) // Observe we have kept outer delay lesser than inner delay

            println("End outer coroutine")
        }
    }

    fun startNestedLinkedCoroutines() {
        // Launch a co-routine within the scope
        rootScope.launch {
            println("Start outer coroutine")

            // Launch a new co-routine within the nested scope
            launch {
                println("Start inner coroutine")
                delay(10000) // Observe we keep delay longer here than the outer delay
                println("End inner coroutine")
            }

            delay(5000) // Observe we have kept outer delay lesser than inner delay

            println("End outer coroutine")
        }
    }

    fun startNestedChildrenCoroutines() {
        // Launch a co-routine within the scope
        rootScope.launch {
            println("Start outer coroutine")

            // Launch a new co-routine within the nested scope
            launch {
                println("Start inner coroutine-1")
                delay(10000) // Observe we keep delay longer here than the outer delay
                println("End inner coroutine-1")
            }.join()

            launch {
                println("Start inner coroutine-2")
                delay(10000) // Observe we keep delay longer here than the outer delay
                println("End inner coroutine-2")
            }.join()

            println("End outer coroutine")
        }
    }

    fun cancel() {
        println("User invokes cancel")
        rootScope.cancel(cause = CancellationException("Cancelled explicitly by user"))
    }


}