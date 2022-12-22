package com.chacha.financeapp.feature_sacco.data.local

import com.chacha.financeapp.readMe.Loan
import com.chacha.financeapp.readMe.Member
import com.chacha.financeapp.readMe.Transaction

data class Sacco(
    val saccoId: String,
    val saccoName: String,
    val member: List<Member>,
    val loans: List<Loan>,
    val transaction: List<Transaction>
)