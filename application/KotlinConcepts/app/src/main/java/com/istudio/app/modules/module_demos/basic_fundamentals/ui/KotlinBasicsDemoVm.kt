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

    /**
     * Arrays in kotlin
     */
    fun arraysInKotlin() {
        // Declaring the array
        var listOfCities = listOf("Bangalore","NewYork","Tokyo")
        // This will print the address of the array
        println(listOfCities)
        // This will print the size of the array
        println(listOfCities.size)
        // This will access the element from a index
        println(listOfCities[1])
        // Check if the array has a particular element
        println(listOfCities.contains("Bangalore"))
        // Another way to check if the element is present in the arrays
        println("Bangalore" in listOfCities)
        // Getting the first element in the array
        println(listOfCities.first())
        // Getting the last element in the array
        println(listOfCities.last())
        // This will throw the error Index out of bound
        println(listOfCities[-1])
    }

    /**
     * List in kotlin
     */
    fun listInKotlin() {
        // List of cities
        var cityList = listOf("Bangalore","Delhi","Chennai","Calcutta")
        // Not possible since its just a list and not a mutable list
        // cityList.add()
        // we can convert one list to another list
        var mutableCityList = cityList.toMutableList()
        // Since now its a mutable list, we can modify the list
        mutableCityList.add("Texas")
        // We can directly add a element at a position also
        mutableCityList.add(1,"Colombo")
        // We can remove a element at a position from th elist
        mutableCityList.removeAt(2)
    }

    /**
     * Map in kotlin
     */
    fun mapInKotlin() {
        val listOfCities = mapOf(
            1 to "Bangalore",
            2 to "Mumbai",
            3 to "Chennai",
        )
        //listOfCities[1] = "Shanghai" // Not possible
        println(listOfCities[1])
        val listOfNames = mutableMapOf(
            1 to "Manish",
            2 to "John",
            3 to "Sam",
        )
        listOfNames[4] = "Anudeep"
        println(listOfNames[4])
    }

    /**
     * Set in kotlin
     */
    fun setInKotlin() {
        var students = setOf("Mahesh","Suresh","Venkatesh","Mahesh")
        // students.add // Not possible
        println(students)
        var cities = mutableSetOf("bangalore","Hassan","Mumbai")
        cities.add("Colombo")
        println(students.contains("Colombo"))
    }

    enum class DaysOfTheWeek { MONDAY,TUESDAY,WEDNESDAY,THURSDAY,FRIDAY,SATURDAY }
    enum class DaysOfTheWeekWithValues(val isWeekend: Boolean = false) {
        MONDAY,TUESDAY,WEDNESDAY,THURSDAY,FRIDAY,SATURDAY(isWeekend = true), SUNDAY(isWeekend = true);
    }

    /**
     * Enum in kotlin
     */
    fun enumInKotlin() {
        // Looping the enum values, And accessing the position
        for(week in DaysOfTheWeek.values()){
            println("$week at position ${week.ordinal}")
        }
        // Looping the enum values, And accessing the position with default values
        for (week in DaysOfTheWeekWithValues.values()){
            // Ordinal helps in printing the position of the current enum class
            println("Week-Name: $week -- at position -- ${week.ordinal} -- is weekend ${week.isWeekend}")
        }
    }


    // backing field
    private var myProperty: Int = 0
    // custom getter
    private val customProperty: Int
        get() {
            println("Getting customProperty value")
            return myProperty
        }

    // custom setter
    private var anotherProperty: String
        get() {
            println("Getting anotherProperty value")
            return "Getter value"
        }
        set(value) {
            println("Setting anotherProperty value to $value")
        }
    /**
     * Having custom accessors
     */
    fun customAccessors() {
        // Using the custom getter
        println(customProperty) // Output: Getting customProperty value

        // Using the custom setter
        anotherProperty = "New Value"
        println(anotherProperty) // Output: Setting anotherProperty value to New Value
    }
}