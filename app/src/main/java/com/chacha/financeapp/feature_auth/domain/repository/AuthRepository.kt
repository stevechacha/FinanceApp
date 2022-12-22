package com.chacha.financeapp.feature_auth.domain.repository

import com.chacha.financeapp.feature_auth.domain.model.Login
import com.chacha.financeapp.feature_auth.domain.model.Register
import com.chacha.financeapp.feature_auth.domain.model.SignIn
import com.chacha.financeapp.feature_auth.domain.model.SignUp
import com.chacha.financeapp.core.util.Resource

interface AuthRepository {
    suspend fun signUp(
        email: String,
        password: String,
        phoneNumber: String,
        idNumber: String
    ): Resource<SignUp>

    suspend fun signIn(
        email: String,
        password: String,
        phoneNumber: String
    ): Resource<SignIn>

    suspend fun registerUser(
        register: Register
    ): Resource<Register>

    suspend fun loginUser(
        login: Login
    ): Resource<Login>

    fun logout()
}