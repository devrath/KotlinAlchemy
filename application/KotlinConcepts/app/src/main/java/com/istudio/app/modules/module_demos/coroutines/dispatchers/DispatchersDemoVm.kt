package com.istudio.app.modules.module_demos.coroutines.dispatchers

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.cancel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import java.util.concurrent.CancellationException
import javax.inject.Inject
import kotlin.coroutines.EmptyCoroutineContext

class DispatchersDemoVm @Inject constructor( ) : ViewModel() {

    // Create a root co-routine scope
    private val rootScope =  CoroutineScope(EmptyCoroutineContext)


    fun demo() {

        rootScope.launch() {
            println("Empty co-routine-context Executes on thread -> ${Thread.currentThread().name}")
        }

        viewModelScope.launch {
            println("View-model-scope executes onExecutes on thread -> ${Thread.currentThread().name}")
        }

        viewModelScope.launch(Dispatchers.Main) {
            println("View-model-scope + Main, executes onExecutes on thread -> ${Thread.currentThread().name}")
        }

        viewModelScope.launch(Dispatchers.Default) {
            println("View-model-scope + Default, executes onExecutes on thread -> ${Thread.currentThread().name}")
        }

        viewModelScope.launch(Dispatchers.IO) {
            println("View-model-scope + IO, executes onExecutes on thread -> ${Thread.currentThread().name}")
        }

        rootScope.launch {
            viewModelScope.launch(Dispatchers.Unconfined) {
                println("View-model-scope + Unconfined, executes onExecutes on thread -> ${Thread.currentThread().name}")
            }
        }

    }

}