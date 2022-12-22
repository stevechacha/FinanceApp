package com.chacha.financeapp.core.data.local.typeconverter

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.lang.reflect.Type
import java.util.*

class DataTypeConverters {
    @TypeConverter
    fun fromStringList(links: List<String?>?): String? {
        if (links == null) {
            return null
        }
        val gson = Gson()
        val type: Type = object : TypeToken<List<String?>?>() {}.type
        return gson.toJson(links, type)
    }

    @TypeConverter
    fun toStringList(linksString: String?): List<String>? {
        if (linksString == null) {
            return null
        }
        val gson = Gson()
        val type: Type = object : TypeToken<List<String?>?>() {}.type
        return gson.fromJson<List<String>>(linksString, type)
    }


    @TypeConverter
    fun fromTimestamp(value: Long?): Date? {
        return value?.let { Date(it) }
    }

    @TypeConverter
    fun dateToTimestamp(date: Date?): Long? {
        return date?.time?.toLong()
    }

    @TypeConverter
    fun fromListIntToString(intList: List<Int>): String = intList.toString()


}