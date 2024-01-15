package com.istudio.app.utils.extensions

import kotlinx.coroutines.CoroutineName
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Job

fun CoroutineScope.printCoroutineScopeInfo() {
    println("<--------------------------------------------->")
    println("Scope: $this")
    println("Name: ${this.coroutineContext[CoroutineName]?.name}")
    println("Context: ${this.coroutineContext}")
    println("Job: ${this.coroutineContext[Job]}")
    println("<--------------------------------------------->")
}