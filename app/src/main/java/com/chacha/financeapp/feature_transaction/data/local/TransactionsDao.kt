package com.chacha.financeapp.feature_transaction.data.local

import androidx.room.*
import androidx.room.Transaction

@Dao
interface TransactionsDao {
    @Query("SELECT * FROM transactions")
    fun getAllTransactions(): List<Transactions>

    @Query("SELECT * FROM transactions WHERE transactionNumber = :transactionNumber")
    fun getTransaction(transactionNumber: String): Transactions

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertTransaction(transactions: Transactions)

    @Delete
    fun deleteTransaction(transactions: Transactions)

    @Update
    fun updateTransaction(transaction: Transaction)

    @Query("SELECT * FROM transactions WHERE id = :id")
    fun getById(id: Long): Transactions
}