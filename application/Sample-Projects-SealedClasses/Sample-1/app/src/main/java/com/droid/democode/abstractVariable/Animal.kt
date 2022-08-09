package com.droid.democode.abstractVariable

import android.util.Log

sealed class Animal {
    init {
        Log.d("Hello","Initializing the animal class")
    }

    abstract val colorOfAnimal : String

}
object Camel : Animal() {
    override val colorOfAnimal: String
        get() = "Yellow"
}

class Monkey : Animal() {
     init {
         Log.d("Hello","Initializing the monkey class")
     }

    override val colorOfAnimal: String
        get() = "Red"
}




