package com.chacha.financeapp.core.presentation.common.navigation

import android.annotation.SuppressLint
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.chacha.financeapp.feature_auth.presentation.register.RegisterScreen
import com.chacha.financeapp.core.presentation.screens.welcome.WelcomeScreen
import com.chacha.financeapp.feature_auth.presentation.create_password.CreatePasswordScreen
import com.chacha.financeapp.feature_auth.presentation.forgot.ForgotPasswordScreen
import com.chacha.financeapp.feature_auth.presentation.login.LoginScreen
import com.chacha.financeapp.feature_auth.presentation.login.LoginViewModel

@SuppressLint("ComposableDestinationInComposeScope")
fun NavGraphBuilder.authNavGraph(navController: NavHostController) {
    navigation(
        route = Graph.AUTHENTICATION,
        startDestination = AuthScreen.Welcome.route
    ){
        composable(AuthScreen.Welcome.route){
            WelcomeScreen(
                onSignUp = {
                    navController.navigate(AuthScreen.Register.route)
                },
                onLogin = {
                    navController.navigate(AuthScreen.Login.route)
                }
            )
        }
        composable(route = AuthScreen.Login.route) {
            LoginScreen(
                onClick = {
                    navController.popBackStack()
                    navController.navigate(Graph.HOME)
                },
                onSignUpClick = {
                    navController.navigate(AuthScreen.Register.route)
                },
                onForgotClick = {
                    navController.navigate(AuthScreen.Forgot.route)
                },
                viewModel = LoginViewModel(hiltViewModel())
            )
        }
        composable(route = AuthScreen.Register.route){
            RegisterScreen(
                onClick = {
                    navController.popBackStack()
                    navController.navigate(Graph.HOME)
                },
                onLoginClick = {
                    navController.navigate(AuthScreen.Login.route)
                }
            )
        }
        composable(route = AuthScreen.CreatePassword.route){
            CreatePasswordScreen(
                onClickAction = {
                    navController.popBackStack()
                    navController.navigate(Graph.HOME)
                }
            )
        }
        composable(route = AuthScreen.Forgot.route){
                ForgotPasswordScreen(
                    onClick = {
                        navController.popBackStack()
                        navController.navigate(Graph.HOME)
                    },
                    onLoginClick = {
                        navController.navigate(AuthScreen.Login.route)
                    }
                )
            }
    }
}


sealed class AuthScreen(val route: String) {
    object Welcome: AuthScreen("welcome")
    object Login : AuthScreen(route = "LOGIN")
    object Register : AuthScreen(route = "REGISTER")
    object Forgot : AuthScreen(route = "FORGOT")
    object CreatePassword : AuthScreen(route = "CREATE_ACCOUNT")
}