package com.istudio.app.modules.module_demos.sealed_class.utils.payment

sealed class Payment {
    data class CashPayment(val amount: Int, val pointId: Int): Payment()
    data class CardPayment(val amount: Int, val orderId: Int): Payment()
    data class BankTransfer(val amount: Int, val orderId: Int): Payment()
}