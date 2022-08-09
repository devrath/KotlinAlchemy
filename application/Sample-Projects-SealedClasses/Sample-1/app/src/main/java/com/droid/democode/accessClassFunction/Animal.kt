package com.droid.democode.accessClassFunction

import android.util.Log

sealed class Animal {
    init {
        Log.d("Hello","Initializing the animal class")
    }

    private val colorOfAnimal = "White"
    var animalNumber = 0

    fun printColorOfAnimal() {
        Log.d("Hello", "Animal color :-> $colorOfAnimal")
    }
}
object Camel : Animal()

class Monkey : Animal() {
     init {
         Log.d("Hello","Initializing the monkey class")
     }
}




