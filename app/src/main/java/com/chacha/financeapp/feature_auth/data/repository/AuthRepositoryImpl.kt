package com.chacha.financeapp.feature_auth.data.repository

import com.chacha.financeapp.core.data.remote.FinancialApi
import com.chacha.financeapp.feature_auth.domain.model.Login
import com.chacha.financeapp.feature_auth.domain.model.Register
import com.chacha.financeapp.feature_auth.domain.model.SignIn
import com.chacha.financeapp.feature_auth.domain.model.SignUp
import com.chacha.financeapp.feature_auth.domain.repository.AuthRepository
import com.chacha.financeapp.core.util.Resource
import com.chacha.financeapp.feature_auth.data.remote.AuthApiService
import javax.inject.Inject


class AuthRepositoryImpl  @Inject constructor(
    private val api: AuthApiService
) : AuthRepository {

    override suspend fun signUp(email: String, password: String, phoneNumber: String, idNumber: String): Resource<SignUp> {
            return try {
                val response = api.signUp(email, password, phoneNumber, idNumber)
                if (response.isSuccessful) {
                    response.body()?.let {
                        return@let Resource.Success(it)
                    } ?: Resource.Error<SignUp>(message = response.message())
                } else {
                    Resource.Error<SignUp>(message = response.message())
                }
            } catch (e: Exception) {
                Resource.Error<SignUp>( message = e.message ?: "An error occurred")
            }

        }

    override suspend fun signIn(email: String, password: String, phoneNumber: String): Resource<SignIn> {
        return try {
            val response = api.signIn(email, password, phoneNumber)
            if (response.isSuccessful) {
                response.body()?.let {
                    return@let Resource.Success(it)
                } ?: Resource.Error<SignIn>(message = response.message())
            } else {
                Resource.Error<SignIn>(message = response.message()) }
        } catch (e: Exception) {
                    Resource.Error<SignIn>( message = e.message ?: "An error occurred")
        }

    }

        override suspend fun registerUser(register: Register): Resource<Register> {
            return try {
                val response = api.registerUser(register)
                if (response.isSuccessful) {
                    response.body()?.let {
                        return@let Resource.Success(it)
                    } ?: Resource.Error<Register>(message = response.message())
                } else {
                    Resource.Error<Register>(message = response.message())
                }
            } catch (e: Exception) {
                Resource.Error<Register>( message = e.message ?: "An error occurred")
            }
        }

        override suspend fun loginUser(login: Login): Resource<Login> {
            return try {
                val response = api.loginUser(login)
                if (response.isSuccessful) {
                    response.body()?.let {
                        return@let Resource.Success(it)
                    } ?: Resource.Error<Login>(message = response.message())
                } else {
                    Resource.Error<Login>(message = response.message())
                }
            } catch (e: Exception) {
                Resource.Error<Login>( message = e.message ?: "An error occurred")
            }
        }

    override fun logout() {
        api.logout()


    }

}