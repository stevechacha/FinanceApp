package com.chacha.financeapp.core.presentation.common.navigation

import androidx.annotation.DrawableRes
import androidx.compose.runtime.Composable
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.chacha.financeapp.R
import com.chacha.financeapp.feature_account.presentation.account.AccountScreen
import com.chacha.financeapp.core.presentation.screens.home.HomeScreen
import com.chacha.financeapp.core.presentation.screens.information.Information
import com.chacha.financeapp.feature_loan.presentation.loan.LoanScreen
import com.chacha.financeapp.core.presentation.screens.overview.Overview
import com.chacha.financeapp.feature_transaction.presentation.transaction.TransactionScreen

@Composable
fun HomeNavGraph(
    navController: NavHostController,
    showBottomBar: (Boolean) -> Unit,
) {
    NavHost(
        navController = navController,
        startDestination = BottomBarScreen.Home.route ,
        route = Graph.HOME
    ){
        composable(BottomBarScreen.Home.route){
            showBottomBar(true)
            HomeScreen(
                onClickAction = {
                    navController.navigate(Graph.DETAILS)
                }
            )

        }
        composable(BottomBarScreen.Transaction.route){
            showBottomBar(true)
            TransactionScreen(
                onClickAction = {}
            )

        }
        composable(BottomBarScreen.Loan.route){
            showBottomBar(true)
            LoanScreen (
                navigateToLogin = {
                    navController.navigate(BottomBarScreen.Accoun.route)
                }
            )

        }
        composable(BottomBarScreen.Account.route){
            showBottomBar(true)
            AccountScreen()

        }
        detailsNavGraph(navController = navController)

    }

}

fun NavGraphBuilder.detailsNavGraph(navController: NavHostController) {
    navigation(
        route = Graph.DETAILS,
        startDestination = DetailsScreen.Information.route
    ) {
        composable(route = DetailsScreen.Information.route) {
            Information() {
                navController.navigate(DetailsScreen.Overview.route)
            }
        }
        composable(route = DetailsScreen.Overview.route) {
            Overview() {
                navController.popBackStack(
                    route = DetailsScreen.Information.route,
                    inclusive = false
                )
            }
        }
    }
}

sealed class DetailsScreen(val route: String) {
    object Information : DetailsScreen(route = "INFORMATION")
    object Overview : DetailsScreen(route = "OVERVIEW")
}


sealed class BottomBarScreen(val route: String, @DrawableRes val icon: Int, val title: String){
    object Home: BottomBarScreen("home", R.drawable.home_icon, "Home")
    object Transaction: BottomBarScreen("transaction",R.drawable.sessions_icon,"Transaction")
    object Loan: BottomBarScreen("loan",R.drawable.loan_icon,"Loan")
    object Account: BottomBarScreen("account",R.drawable.about_icon,"Account")
    object Accoun: BottomBarScreen("account",R.drawable.about_icon,"Account")
}

val bottomNavigationItems = listOf(
    BottomBarScreen.Home,
    BottomBarScreen.Transaction,
    BottomBarScreen.Loan,
    BottomBarScreen.Account
)