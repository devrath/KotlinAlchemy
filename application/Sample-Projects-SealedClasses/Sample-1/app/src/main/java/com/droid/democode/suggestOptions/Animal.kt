package com.droid.democode.suggestOptions

sealed class Animal {
    object Cat : Animal() // We can define a Object classes like this
    data class Dog(val name: String) : Animal() // We can define data classes like this
}
object Camel : Animal()
object Monkey : Animal()
