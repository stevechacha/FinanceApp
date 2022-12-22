package com.chacha.financeapp.core.data.local.typeconverter

import androidx.room.TypeConverter

class DoubleTypeConverter {
    @TypeConverter
    fun fromString(value: String?): Double? {
        return value?.toDouble()
    }

    @TypeConverter
    fun doubleToString(double: Double?): String? {
        return double?.toString()
    }
}