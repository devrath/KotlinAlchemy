package com.istudio.app.modules.module_demos.sealed_class.utils.animals

sealed class Animal {

    // using companion object
    companion object {
        const val color : String = "Red"
        const val age : Int =  50
    }
    
    // -----------> This is not possible
    //const val height : Int =  50

    // Private member variable
    private val privateCharacteristics : String = "They are super powers"

    // Public member variable
    val publicCharacteristics : String = "They are alive"

    // Public member function
    fun publicCharacteristicsFunctionalities() {
        println("We are printing public characteristics")
    }

    // Private data object
    private data object Cat : Animal()

    data class Dog(val name:String): Animal()
}

data object Camel : Animal()
