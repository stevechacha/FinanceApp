package com.chacha.financeapp.feature_member.data.remote.dto

import androidx.room.Entity
import com.chacha.financeapp.readMe.Account
import java.util.*

/*
* •	name (e.g. string)
•	contact information (e.g. phone number, email address, mailing address) (e.g. string)
•	membership status (e.g. active, inactive) (e.g. string or enumerated type)
•	membership ID (e.g. string or integer)

*
* */
@Entity(tableName = "member")
data class MemberDto(
    var memberId: Int = 0,
    var name: String = "",
    var phoneNumber: String,
    var email: String,
    var idNumber: String,
    var memberStatus: String,
    var accountBalance: Double = 0.0,
    var account: List<Account>,
    var memberShipDate: Date
)


