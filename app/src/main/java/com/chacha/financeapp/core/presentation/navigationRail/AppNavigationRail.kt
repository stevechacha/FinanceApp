package com.chacha.financeapp.core.presentation.navigationRail

import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationRail
import androidx.compose.material3.NavigationRailItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.chacha.financeapp.presentation.common.navigation.BottomBarScreen
import com.chacha.financeapp.presentation.common.navigation.bottomNavigationItems
import com.chacha.financeapp.presentation.common.theme.FinanceAppTheme
import com.chacha.financeapp.core.presentation.navigation_bar.AppNavigationBar

@Composable
fun AppNavigationRail(
    navController: NavHostController
) {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination
    NavigationRail(
        modifier = Modifier.fillMaxHeight(),
    ) {
        bottomNavigationItems.forEach { destination ->
            NavigationRailItem(
                selected = currentDestination?.hierarchy?.any { it.route == destination.route } == true,
                onClick = {
                    navController.navigate(destination.route) {
                        popUpTo(BottomBarScreen.Home.route) { inclusive = true }
                        launchSingleTop = true
                        restoreState = true
                    }
                },
                icon = {
                    Icon(
                        painter = painterResource(id = destination.icon),
                        contentDescription = destination.title,
                    )
                },
                label = {
                    Text(text = destination.title)
                },
                alwaysShowLabel = true
            )
        }
    }

}

@Preview
@Composable
fun AppNavigationRailPreview() {
    FinanceAppTheme {
        AppNavigationRail(rememberNavController())
    }
}