package com.istudio.app.modules.module_exercises.exercise_2

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.joinAll
import kotlinx.coroutines.launch
import javax.inject.Inject
import kotlin.concurrent.thread

class Exercise2vm @Inject constructor( ) : ViewModel() {

    fun blockingTypeDemo() {
        val beforeThreadName = Thread.currentThread().name
        println("Before calling threads, Execute in -> $beforeThreadName")
        // Call thread 1
        initiateNewThread(1)
        // Call thread 2
        initiateNewThread(2)
        val threadNameLater = Thread.currentThread().name
        Thread.sleep(600)
        println("After calling threads, Execute in -> $threadNameLater")
    }

    private fun initiateNewThread(threadNo : Int) {
        thread {
            val threadName = Thread.currentThread().name
            for (i in 1..4){
                println("Task $threadNo with count$i is running on -> $threadName")
                Thread.sleep(100)
            }
        }
    }


    fun suspendingTypeDemo() {
        val beforeThreadName = Thread.currentThread().name
        println("Before calling threads, Execute in -> $beforeThreadName")
        CoroutineScope(Dispatchers.Main.immediate).launch {
            joinAll(
                // Call thread 1
                launch { initiateNewCoroutine(1) },
                // Call thread 2
                launch { initiateNewCoroutine(2) }
            )
        }
        val threadNameLater = Thread.currentThread().name
        println("After calling threads, Execute in -> $threadNameLater")
    }


    private suspend fun initiateNewCoroutine(threadNo : Int) {
        val threadName = Thread.currentThread().name
        for (i in 1..4){
            println("Task $threadNo with count$i is running on -> $threadName")
            delay(100)
        }
    }

}