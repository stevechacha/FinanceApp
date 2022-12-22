package com.chacha.financeapp.feature_auth.domain.model

data class Login(
    val Email: String?,
    val Password: String,
    val PhoneNumber: String?
)
