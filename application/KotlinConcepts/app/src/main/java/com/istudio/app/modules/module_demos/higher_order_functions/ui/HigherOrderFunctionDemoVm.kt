package com.istudio.app.modules.module_demos.higher_order_functions.ui

import androidx.lifecycle.ViewModel
import javax.inject.Inject

class HigherOrderFunctionDemoVm @Inject constructor( ) : ViewModel() {

    // <-------------- Passing Functions as Parameters -------------->
    fun performOperation(input: Int, operation: (Int) -> Int): Int {
        return operation(input)
    }
    // <-------------- Passing Functions as Parameters -------------->


    // <-------------- Returning Functions as Parameters ------------>
    fun createCalculator(operator: String): (Int, Int) -> Int {
        return when (operator) {
            "add" -> { a, b -> a + b }
            "subtract" -> { a, b -> a - b }
            "multiply" -> { a, b -> a * b }
            "divide" -> { a, b -> if (b != 0) a / b else 0 }
            else -> throw IllegalArgumentException("Unknown operator: $operator")
        }
    }

    // <-------------- Returning Functions as Parameters ------------>


}