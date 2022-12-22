package com.chacha.financeapp.feature_payment.data.local

import java.util.*


data class Payments(
    val paymentAmount: Double,
    val paymentDate: Date,
    val account: String
)