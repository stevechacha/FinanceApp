package com.chacha.financeapp.feature_transaction.data.local.typeconverter

import androidx.room.*
import com.chacha.financeapp.feature_transaction.data.local.Transactions
import java.util.*



class TransactionTypeConverter {
    @TypeConverter
    fun fromTransaction(transactions: Transactions): String {
        // Convert the Transaction object to a String
        return "${transaction.id},${transaction.accountId},${transaction.amount},${transaction.timestamp}"
    }

    @TypeConverter
    fun toTransaction(data: String): Transactions{
        // Convert the String back to a Transaction object
        val parts = data.split(",")
        return Transaction(parts[0].toInt(), parts[1].toInt(), parts[2].toDouble(), parts[3].toLong())
    }

    @TypeConverter
    fun fromTransactions(transactions: Transactions): String {
        // Convert the Transaction object into a string representation
        return transactions.toString()
    }

    @TypeConverter
    fun toTransactions(data: String): Transaction {
        // Convert the string representation into a Transaction object
        return Transactions.fromString(data)
    }


}









