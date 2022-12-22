package com.chacha.financeapp.feature_saving.data.local

data class SavingsAccount(
    var balance: Double,
    var interestRate: Double,
    var accountType: String
){
    fun deposit(amount: Double){
        balance += amount
    }
    fun withdraw(amount: Double){
        balance -= amount
    }

    fun calculateInterest(): Double{
        return balance* interestRate
    }
}
