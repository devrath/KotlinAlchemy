package com.istudio.app.modules.module_demos.coroutines.coroutine_cancellation

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.cancel
import kotlinx.coroutines.cancelChildren
import kotlinx.coroutines.delay
import kotlinx.coroutines.joinAll
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject
import kotlin.concurrent.thread

class CoroutineCancelSelectionVm @Inject constructor( ) : ViewModel() {

    private val rootScope =  CoroutineScope(Dispatchers.Default)

    fun start() {
        rootScope.launch {
            longRunningOperation()
        }.invokeOnCompletion {
            it?.let {
                val message = it?.message
                println("Exception thrown:-> $message")
            }?:run {
                println("Scope completed without exception")
            }
        }
    }

    fun cancelRoot(){
        rootScope.cancel()
    }

    fun cancelChildren(){
        rootScope.coroutineContext.cancelChildren()
    }

    private suspend fun longRunningOperation() = withContext(Dispatchers.Default){

        for (i in 1..30){
            println("Current count $i")
            delay(1000)
        }
    }


}