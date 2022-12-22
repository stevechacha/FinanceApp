package com.chacha.financeapp.feature_auth.data.remote

import com.chacha.financeapp.feature_auth.domain.model.Login
import com.chacha.financeapp.feature_auth.domain.model.Register
import com.chacha.financeapp.feature_auth.domain.model.SignIn
import com.chacha.financeapp.feature_auth.domain.model.SignUp
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.Field
import retrofit2.http.POST

interface AuthApiService {
    @POST("signup")
    suspend fun signUp(
        @Field("email") email: String,
        @Field("password") password: String,
        @Field("phoneNumber") phoneNumber: String,
        @Field("idNumber") idNumber: String
    ): Response<SignUp>

    @POST("login")
    suspend fun signIn(
        @Field("email") email: String,
        @Field("password") password: String,
        @Field("phoneNumber") phoneNumber: String
    ): Response<SignIn>

    @POST("register")
    suspend fun registerUser(
        @Body register: Register
    ): Response<Register>

    @POST("login")
    suspend fun loginUser(
        @Body login: Login
    ): Response<Login>

    fun logout()

}