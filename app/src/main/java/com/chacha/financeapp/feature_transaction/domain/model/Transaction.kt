package com.chacha.financeapp.feature_transaction.domain.model

import com.chacha.financeapp.readMe.Account
import java.util.*

/*

transaction amount (e.g. decimal or integer)
•	transaction type (e.g. deposit, withdrawal, transfer,loan payment) (e.g. string or enumerated type)
•	transaction date (e.g. date or datetime object)
•	transaction ID (e.g. string or integer)

*/
data class Transaction(
    var transactionId: Int = 0,
    var transactionAmount: Double = 0.0,
    var transactionType: String = "",
    var transactionDate: Date = Date(),
    var account: Account

)

