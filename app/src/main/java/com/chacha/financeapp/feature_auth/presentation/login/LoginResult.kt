package com.chacha.financeapp.feature_auth.presentation.login

import com.chacha.financeapp.core.util.Resource
import com.chacha.financeapp.feature_auth.domain.model.Login

data class LoginResult(
    val passwordError: String? = null,
    val usernameError: String? = null,
    val result: Resource<Unit>? = null
)
