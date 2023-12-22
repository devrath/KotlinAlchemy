package com.istudio.app.modules.module_demos.sealed_class.utils

sealed class Animal {

    companion object {
        const val color : String = "Red"
        const val age : Int =  50
    }

    //const val height : Int =  50 // -----------> This is not possible

    private val commonCharacteristics : String = "They are alive"
    private data object Cat : Animal()
    data class Dog(val name:String): Animal()
}

data object Camel : Animal()
