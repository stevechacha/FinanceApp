package com.chacha.financeapp.feature_auth.domain.use_cases

import com.chacha.financeapp.feature_auth.domain.model.Login
import com.chacha.financeapp.feature_auth.domain.repository.AuthRepository
import com.chacha.financeapp.feature_auth.presentation.login.LoginResult

class LoginUseCase(
    private val loginRepository: AuthRepository
){
    suspend operator fun invoke(
        email: String,
        password: String,
        phoneNumber: String
    ): LoginResult {

        val usernameError = if (email.isBlank()) "User name cannot be blank" else null
        val passwordError = if (password.isBlank()) "Password cannot be blank" else null


        if (usernameError != null) {
            return LoginResult(
                usernameError = usernameError
            )
        }

        if (passwordError != null) {
            return LoginResult(
                passwordError = passwordError
            )
        }

        val loginRequest = Login(
            Email = email.toString().trim(),
            Password = password.toString().trim(),
            PhoneNumber = phoneNumber.toString().trim()
        )

        return LoginResult(
            result = loginRepository.loginUser(loginRequest)
        )



    }
}