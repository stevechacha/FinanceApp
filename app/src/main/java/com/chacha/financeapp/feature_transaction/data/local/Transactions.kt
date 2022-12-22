package com.chacha.financeapp.feature_transaction.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.chacha.financeapp.feature_account.data.local.Accounts
import com.chacha.financeapp.feature_loan.data.local.Loans
import java.util.*

/*

transaction amount (e.g. decimal or integer)
•	transaction type (e.g. deposit, withdrawal, transfer,loan payment) (e.g. string or enumerated type)
•	transaction date (e.g. date or datetime object)
•	transaction ID (e.g. string or integer)

*/
@Entity(tableName = "transactions")
data class Transactions(
    var transactionId: Int = 0,
    val transactionNumber: String,
    var transactionAmount: Double = 0.0,
    var transactionType: String = "",
    var transactionDate: Date = Date(),
    var accounts: Accounts

)


@Entity(tableName = "transaction")
data class Transaction(
    val deposits: List<Deposits>,
    val withdrawal: List<Withdrawals>,
    val transfer: List<Accounts>,
    val loansRepayment: Loans
)


@Entity(tableName = "deposits")
data class Deposits(
    @PrimaryKey(autoGenerate = false) val id: Int,
    val depositAccount: String,
    val depositAmount: Double,
    val depositDate: Date,
)


@Entity(tableName = "withdrawals")
data class Withdrawals(
    @PrimaryKey(autoGenerate = false) val id: Int,
    val accountWithdrawals: Int,
    val amountWithdrawals: Double,
    val withdrawalDate: Date
)

@Entity(tableName = "transaction_history")
data class TransactionHistoryEntity(
    @PrimaryKey(autoGenerate = false) val id: Long,
    val transactionAmount: Double,
    val transactionDate: Date,
    val transactionCurrency: String,
    val transactionNumber: Int,
    val transactionType: String,
    val transactionDescription: String,
    val transactionFee: Double,
    val transactionParties: List<TransactionPartyEntity>
)

@Entity
data class TransactionPartyEntity(
    val partyIcon: Int,
    val partyName: String,
    val partyNumber: String,
    val partyAccountNumber: String,
    val partyBank: String,
    val partyBankCode: String,
    val partyType: String,


)

data class Transactionss(
    val transactionName: String,
    val transactionNumber: String,
    val transactionAmount: Double,
    val transactionTime: String,
    val transactionType: String,
    val transactionDescription: String,
    val transactionFee: Double?,
    val transactionDate: Date

)





