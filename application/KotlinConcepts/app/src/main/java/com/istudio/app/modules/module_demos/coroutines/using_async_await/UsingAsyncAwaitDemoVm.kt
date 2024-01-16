package com.istudio.app.modules.module_demos.coroutines.using_async_await

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.CoroutineName
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.async
import kotlinx.coroutines.awaitAll
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

class UsingAsyncAwaitDemoVm @Inject constructor( ) : ViewModel() {

    private val scopeJob = Job()

    private val ourScope =  CoroutineScope(scopeJob + Dispatchers.Default)

    fun demo() {
        try {
            ourScope.launch(CoroutineName("GrandParent")) {

                val endResult = (1..15).toList().map { inputValue ->
                    async {
                        delay(100)
                        inputValue
                    }
                }.awaitAll().sum()
                println("Final Result:-> $endResult")
            }
        }catch (ex:Exception){
            println("Exception caught outside GrandParent scope")
        }
    }

    fun rootCancel() {
        scopeJob?.cancel()
    }

}