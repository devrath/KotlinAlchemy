package com.istudio.app.modules.module_demos.basic_fundamentals.ui

import androidx.lifecycle.ViewModel
import com.istudio.app.modules.module_demos.basic_fundamentals.utils.Student
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


@HiltViewModel
class KotlinBasicsDemoVm  @Inject constructor( ) : ViewModel() {

    /**
     * Concatenating of strings
     */
    fun stringsInKotlin() {
        // Assigning explicitly the data type and then setting a value to it
        // This will always accept only the integer
        var age : Int = 21
        var firstName : String = "Tony"
        // Kotlin can infer the values so that we need not have to explicitly mention them, Meaning datatype , we need not have to add
        var lastName : String = "Stark"
        println("My name is $firstName $lastName and I am $age years old scientist")
        // Appending the variables in the string is reformatting it is called string interpolation
    }

    /**
     * Comparison Operators
     */
    fun comparisionOperators() {
        val conditionCheck = 25 > 21
        println("Condition Check Result:-> $conditionCheck")

        var firstValue = Student("Mahesh",22)
        var secondValue = Student("Mahesh",22)

        // DoubleEqual => Check if both variables are equal by value
        val resultValueOne =  firstValue==secondValue
        println("DoubleEqual:-> $resultValueOne")// Result: true

        // TripleEqual => Check if both variables are equal by reference
        val resultValueTwo =  firstValue===secondValue
        println("TripleEqual:-> $resultValueTwo")// Result: false
    }

    /**
     * Large tree conditions
     */
    fun largeTreeConditions() {
        val input = "Hello"

        // We explicitly specify that the output will be string
        // if we does not specify and there can be possibility that value returned will be the value of input
        val finalOutput : String = if( input == "a" ) {
            "a"
        } else if( input == "b" ){
            "b"
        } else if( input == "c" ){
            "c"
        } else{
            "Hello"
        }

        println("Result:-> $finalOutput")
    }

    /**
     * Defining and using nullable values
     */
    fun definingAndUsingNullable() {
        // If we need to assign a null value to a variable, We explicitly need to mention it
        var name : String ? = null
        println(name)   // This will print null
        //name.length   // This will throw a compiler error referring, null check is needed
        name = "hello"
        println(name)   // We can re-assign a different value to a null variable
        println("<-------------------------------------------->")
        // For forcing-ly to use a null value
        var city : String ? = null
        println(city!!.length) // This will crash since city is null here
    }

    /**
     * Storing pairs and triplets
     */
    fun storingPairsAndTriplets() {
        // Demo: Pair
        val details : Pair<String,String> = Pair("Mahesh","USA")
        val (name,city) = details;
        println("Name:-> $name")
        println("City:-> $city")
        println("<-------------------------------------------->")
        // Demo: Triplets
        val fullDetails : Triple<String,String,Int> = Triple("Mahesh","USA",21)
        val (nameX,cityX,ageX) = fullDetails
        println("Name:-> $nameX")
        println("City:-> $cityX")
        println("Age:-> $ageX")
        println("<-------------------------------------------->")
    }


}