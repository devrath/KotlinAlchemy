package com.istudio.app.modules.module_demos.sealed_class.ui

import androidx.lifecycle.ViewModel
import com.istudio.app.modules.module_demos.sealed_class.utils.animals.Tiger
import com.istudio.app.modules.module_demos.sealed_class.utils.payment.Payment
import javax.inject.Inject

class SealedClassDemoVm @Inject constructor( ) : ViewModel() {

    fun createSealedClassObject() {
        val tigerInstance = Tiger()
        tigerInstance.printName()
    }

    fun accessPublicMembers() {
        val tigerInstance = Tiger()
        println(tigerInstance.publicCharacteristics)
    }


    fun accessPublicFunction() {
        val tigerInstance = Tiger()
        tigerInstance.publicCharacteristicsFunctionalities()
    }

    fun suggestAllPossibleOptions(payment: Payment) {
        when (payment) {
            is Payment.BankTransfer -> {
                println("Bank Transfer")
            }
            is Payment.CardPayment -> {
                println("Card Payment")
            }
            is Payment.CashPayment -> {
                println("Cash Payment")
            }
        }
    }

}