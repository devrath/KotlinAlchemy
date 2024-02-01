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



    // 1- With Parameters and Return Value
    fun type1() {
        val add1:(Int,Int) -> Int = { a:Int , b:Int -> a+b }
        println(add1(1,2))
    }

    // 2- With Parameters and no return value
    fun type2() {
        val add2 : (Int,Int) -> Unit = { a,b -> println(a+b) }
        add2(1,2)
    }

    // 3- No Parameters but with return value
    fun type3() {
        val add3 : () -> String = { "Hello world" }
        println(add3())
    }


    // 4- No Parameters and no return value
    fun type4() {
        val add4 : () -> Unit = { println("Hello World") }
        add4.invoke()
    }


}