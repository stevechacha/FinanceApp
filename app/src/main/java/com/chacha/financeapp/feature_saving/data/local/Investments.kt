package com.chacha.financeapp.feature_saving.data.local

data class Investment(
    var investmentId: Int = 0,
    var investmentType: String = "",
    var amountInvested: Double = 0.0,
    var returnRate: Double = 0.0
)


