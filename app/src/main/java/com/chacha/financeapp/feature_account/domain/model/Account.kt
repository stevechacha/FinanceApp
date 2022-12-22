package com.chacha.financeapp.feature_account.domain.model

import com.chacha.financeapp.readMe.Transaction

/*
* •	account balance (e.g. decimal or integer)
•	transaction hi story (e.g. list of Transaction objects)
•	account type (e.g. checking, savings, loan) (e.g. string ,, enumerated type)
•	account ID (e.g. string or integer)
*
* */

data class Account(
    val accountId: String,
    var accountBalance: Double,
    var transactionHistory: List<Transaction>,
    var accountType: String,
)

