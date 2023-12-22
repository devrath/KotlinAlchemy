package com.istudio.app.modules.module_demos.sealed_class.ui

import androidx.lifecycle.ViewModel
import com.istudio.app.modules.module_demos.sealed_class.utils.Tiger
import javax.inject.Inject

class SealedClassDemoVm @Inject constructor( ) : ViewModel() {

    fun createSealedClassObject() {
        val tigerInstance = Tiger()
        tigerInstance.printName()
    }

}