package com.istudio.app.modules.module_demos.coroutines

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineDispatcher
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
     *  **************** DEMO: Create a coroutine scope ****************
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
     * **************** DEMO: Create a coroutine scope ****************
     */


    /**
     *  **************** DEMO: Wait for coroutine to finish ****************
     */
    fun waitForCoRoutineToFinish() {
        //println("Before the view model scope")
        viewModelScope.launch {
            println("Before the coroutine scope") // - 1
            CoroutineScope(EmptyCoroutineContext).launch {
                println("Before the delay") // - 2
                delay(1000)
                println("After the delay") // - 3
            }.join()
            println("After the coroutine scope") // - 4
        }
        //println("After the view model scope")
    }
    /**
     * ****************  DEMO: Wait for coroutine to finish ****************
     */

    /**
     * ****************  DEMO: Sequential coroutines ***********************
     */
    fun sequentialCoroutiens() {
        viewModelScope.launch {
            println("JOB-1: Before the coroutine scope")
            CoroutineScope(EmptyCoroutineContext).launch {
                println("JOB-1: ----> Before the delay")
                delay(1000)
                println("JOB-1: ----> After the delay")
            }.join()
            println("JOB-1: After the coroutine scope")
            println("---------------------------------")
            println("JOB-2: Before the coroutine scope")
            CoroutineScope(EmptyCoroutineContext).launch {
                println("JOB-2: ----> Before the delay")
                delay(1000)
                println("JOB-2: ----> After the delay")
            }.join()
            println("JOB-2: After the coroutine scope")
        }
    }
    /**
     * ****************  DEMO: Sequential coroutines ***********************
     */

    /**
     * ****************  DEMO: Scope And Context Relationship **************
     */
    fun scopeAndContextRelationshipDemo() {

        viewModelScope.launch(CoroutineName("Pikachuu")) {

            val name = coroutineContext[CoroutineName]?.name
            println("OuterMostCoroutine:-> $name")

            launch {

                val name = coroutineContext[CoroutineName]?.name
                println("InnerCoroutine1:-> $name")

                launch {

                    val name = coroutineContext[CoroutineName]?.name
                    println("InnermostCoroutine1:-> $name")

                }.join()

            }.join()

            launch {

                val name = coroutineContext[CoroutineName]?.name
                println("InnerCoroutine2:-> $name")

                launch(CoroutineName("Goku ")) {

                    val name = coroutineContext[CoroutineName]?.name
                    println("InnermostCoroutine2:-> $name")

                }.join()

            }.join()

        }

    }
    /**
     * ****************  DEMO: Scope And Context Relationship **************
     */

}