package com.istudio.app.modules.module_demos.coroutines.simple_structured_concurrency

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.cancel
import kotlinx.coroutines.cancelChildren
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

class SimpleStructuredConcurrencyDemoVm @Inject constructor( ) : ViewModel() {

    // Create a root co-routine scope
    private val rootScope =  CoroutineScope(Dispatchers.Default)

    fun start() {
        // Launch a co-routine within the scope
        rootScope.launch {
            println("Start outer coroutine")

            // Create a nested co-routine scope
            val nestedScope =  CoroutineScope(Dispatchers.Default)

            // Launch a new co-routine within the nested scope
            nestedScope.launch {
                println("Start inner coroutine")
                delay(1000) // Observe we keep delay longer here than the outer delay
                println("End inner coroutine")
            }

            delay(500) // Observe we have kept outer delay lesser than inner delay

            println("End outer coroutine")
        }
    }


}