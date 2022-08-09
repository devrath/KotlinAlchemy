package com.droid.democode.accessClassVariable

import android.util.Log

sealed class Animal {
    init {
        Log.d("Hello","Initializing the animal class")
    }
    val colorOfAnimal = "White" // This is accessible because of open keyword
    object Cat : Animal() // We can define a Object classes like this
    data class Dog(val name: String) : Animal() // We can define data classes like this
}
object Camel : Animal()

class Monkey : Animal() {
     init {
         Log.d("Hello","Initializing the monkey class")
     }
}




