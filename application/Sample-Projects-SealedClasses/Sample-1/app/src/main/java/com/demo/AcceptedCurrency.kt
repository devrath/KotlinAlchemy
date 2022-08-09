package com.demo


sealed class AcceptedCurrency {
  abstract val valueInDollars: Double

  var amount: Double = 0.0

  val name: String
    get() = when (this) {
      is Euro -> "Euro"
      is Dollar -> "Dollars"
      is Crypto -> "NerdCoin"
    }

  fun totalValueInDollars(): Double {
    return amount * valueInDollars
  }
}

class Dollar : AcceptedCurrency() {
  override val valueInDollars = 1.0
}

class Euro : AcceptedCurrency() {
  override val valueInDollars = 1.25
}

class Crypto : AcceptedCurrency() {
  override val valueInDollars = 2534.92
}