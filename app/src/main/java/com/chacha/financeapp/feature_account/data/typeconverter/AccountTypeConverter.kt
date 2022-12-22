package com.chacha.financeapp.readMe.typeconverter

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverter
import androidx.room.TypeConverters
import com.chacha.financeapp.feature_account.data.local.Accounts


@Entity
@TypeConverters(AccountTypeConverter::class)
data class Account(
    @PrimaryKey val accountNumber: String,
    val accountHolder: String,
    val balance: Double
)


class AccountTypeConverter {
    @TypeConverter
    fun fromAccount(accounts: Accounts): String {
        // Convert the Account object to a String
        return "${accounts.accountId},${accounts.accountType},${accounts.accountBalance}"
    }

    @TypeConverter
    fun toAccount(data: String): Accounts {
        // Convert the String back to an Account object
        val parts = data.split(",")
        return Accounts(parts[0].toInt(), parts[1], parts[2].toDouble())
    }
}


