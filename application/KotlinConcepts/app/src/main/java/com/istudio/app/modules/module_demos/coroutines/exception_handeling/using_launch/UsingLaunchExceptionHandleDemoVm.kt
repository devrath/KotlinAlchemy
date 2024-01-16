package com.istudio.app.modules.module_demos.coroutines.exception_handeling.using_launch

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.CoroutineName
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

class UsingLaunchExceptionHandleDemoVm @Inject constructor( ) : ViewModel() {

    private val scopeJob = Job()

    private val ourScope =  CoroutineScope(scopeJob + Dispatchers.Default)

    // <----------------------->   No Exception Handler   <----------------------->
    fun demo1() {

        ourScope.launch(CoroutineName("Parent")) {
            try {
                ourScope.launch(CoroutineName("Child-1")) {
                    try {
                        delay(10000)
                    }catch (ex : Exception){
                        println("Child-1 throws exception(Normal catch) ${ex.localizedMessage}")
                    }
                }.invokeOnCompletion { throwable ->
                    if(throwable!=null){
                        // Exception thrown
                        println("Child-1 throws exception ${throwable.localizedMessage}")
                    }else{
                        // Normal completion of coroutine
                        println("Child-1 is complete")
                    }
                }

                ourScope.launch(CoroutineName("Child-2")) {
                    /*try {
                        throw RuntimeException("Child-2 throws exception")
                        delay(10000)
                    }catch (ex : Exception){
                        println("Child-2 throws exception(Normal catch) ${ex.localizedMessage}")
                    }*/
                    throw RuntimeException("Child-2 throws exception")
                }.invokeOnCompletion{ throwable ->
                    if(throwable!=null){
                        // Exception thrown
                        println("Child-1 throws exception ${throwable.localizedMessage}")
                    }else{
                        // Normal completion of coroutine
                        println("Child-2 is complete")
                    }
                }
            }catch (ex : Exception){
                println("Parent throws exception(Normal catch) ${ex.localizedMessage}")
            }

            // Outer delay
            delay(15000)
        }.invokeOnCompletion{ throwable ->
            if(throwable!=null){
                // Exception thrown
                println("Parent throws exception ${throwable.localizedMessage}")
            }else{
                // Normal completion of coroutine
                println("Parent is complete")
            }
        }

    }
    // <----------------------->   No Exception Handler   <----------------------->

    // <----------------------->   Catch locally using try catch   <------------->
    fun demo2() {

        ourScope.launch(CoroutineName("Parent")) {
            try {
                ourScope.launch(CoroutineName("Child-1")) {
                    try {
                        delay(10000)
                    }catch (ex : Exception){
                        println("Child-1 throws exception(Normal catch) ${ex.localizedMessage}")
                    }
                }.invokeOnCompletion { throwable ->
                    if(throwable!=null){
                        // Exception thrown
                        println("Child-1 throws exception ${throwable.localizedMessage}")
                    }else{
                        // Normal completion of coroutine
                        println("Child-1 is complete")
                    }
                }

                ourScope.launch(CoroutineName("Child-2")) {
                    try {
                        throw RuntimeException("Child-2 throws exception")
                        delay(10000)
                    }catch (ex : Exception){
                        println("Child-2 throws exception(Normal catch) ${ex.localizedMessage}")
                    }
                }.invokeOnCompletion{ throwable ->
                    if(throwable!=null){
                        // Exception thrown
                        println("Child-1 throws exception ${throwable.localizedMessage}")
                    }else{
                        // Normal completion of coroutine
                        println("Child-2 is complete")
                    }
                }
            }catch (ex : Exception){
                println("Parent throws exception(Normal catch) ${ex.localizedMessage}")
            }

            // Outer delay
            delay(15000)
        }.invokeOnCompletion{ throwable ->
            if(throwable!=null){
                // Exception thrown
                println("Parent throws exception ${throwable.localizedMessage}")
            }else{
                // Normal completion of coroutine
                println("Parent is complete")
            }
        }

    }
    // <----------------------->   Catch locally using try catch   <------------->

}