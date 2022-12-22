package com.chacha.financeapp.feature_account.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.chacha.financeapp.feature_transaction.data.local.Transactions

/*
* •	account balance (e.g. decimal or integer)
•	transaction hi story (e.g. list of Transaction objects)
•	account type (e.g. checking, savings, loan) (e.g. string ,, enumerated type)
•	account ID (e.g. string or integer)
*
* */
@Entity(tableName = "accounts")
data class Accounts(
    val id: Int,
    val accountId: String,
    var accountBalance: Double,
    val accountIcon: String,
    var transactionHistory: List<Transactions>,
    var accountType: String,
    val accountHolderName: String,
    val accountNumber: String,
)
