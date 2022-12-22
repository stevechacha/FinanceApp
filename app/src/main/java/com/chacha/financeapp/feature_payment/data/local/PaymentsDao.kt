package com.chacha.financeapp.feature_payment.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.chacha.financeapp.feature_payment.data.local.typeconverter.Payment

@Dao
interface PaymentsDao {
    @Query("SELECT * FROM payment")
    fun getAll(): List<Payment>

    @Insert
    fun insert(payment: Payment)
}