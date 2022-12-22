package com.chacha.financeapp.feature_payment.data.local.typeconverter

import androidx.room.*
import com.chacha.financeapp.feature_payment.data.local.Payments


class PaymentTypeConverter {
    @TypeConverter
    fun fromPayment(payment: Payments): String {
        return "${payment.amount}-${payment.date}"
    }

    @TypeConverter
    fun toPayment(data: String): Payments {
        val parts = data.split("-")
        return Payments(parts[0].toDouble(), parts[1])
    }
}



