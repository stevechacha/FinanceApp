package com.chacha.financeapp.feature_auth.domain.model

data class Register(
    val Email: String,
    val Password: String,
    val PhoneNumber: String,
    val IdNumber: String
)
