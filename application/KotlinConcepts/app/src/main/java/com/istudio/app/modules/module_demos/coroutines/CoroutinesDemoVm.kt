package com.istudio.app.modules.module_demos.coroutines

import android.app.Application
import android.widget.Toast
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.CoroutineName
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject
import kotlin.coroutines.CoroutineContext
import kotlin.coroutines.EmptyCoroutineContext

@HiltViewModel
class CoroutinesDemoVm @Inject constructor(val context: Application) : AndroidViewModel(context) {


    /**
     * DEMO: Create a coroutine scope
     */
    fun createCoroutineScopeDemo() {
        println("Before the scope")
        CoroutineScope(context = prepareContext()).launch {

            val name = coroutineContext[CoroutineName]?.name

            println("$name:-> Before the delay")
            delay(1000)
            println("$name:-> After the delay")
        }
        println("After the scope")
    }

    private fun prepareContext(): CoroutineContext {
        val context = EmptyCoroutineContext
        val name = "MyCoroutine"
        val job = Job()
        val exceptionHandler = CoroutineExceptionHandler{ _ , throwable ->
            println("Error in coroutine: $throwable")
        }
        val dispatcher = Dispatchers.Default

      return (context + job + CoroutineName(name) + dispatcher + exceptionHandler)
    }
    /**
     * DEMO: Create a coroutine scope
     */

}