package com.chacha.financeapp.feature_member.data.typeconverter

import androidx.room.TypeConverter
import com.chacha.financeapp.feature_member.data.local.Members
import java.util.*

class MemberTypeConverter {
    @TypeConverter
    fun fromTimestamp(value: Long?): Date? {
        return value?.let { Date(it) }
    }

    @TypeConverter
    fun dateToTimestamp(date: Date?): Long? {
        return date?.time?.toLong()
    }

    @TypeConverter
    fun fromMember(members: Members): String {
        return "${members.memberId},${members.name},${members.email}"
    }

    @TypeConverter
    fun toMember(data: String): Members {
        val parts = data.split(",")
        return Members(parts[0].toInt(), parts[1], parts[2], parts[3], parts[4], parts[5])
    }


}

