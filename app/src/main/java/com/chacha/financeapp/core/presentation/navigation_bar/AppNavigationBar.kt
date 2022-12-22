package com.chacha.financeapp.core.presentation.navigation_bar

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.chacha.financeapp.core.presentation.common.navigation.BottomBarScreen
import com.chacha.financeapp.core.presentation.common.navigation.bottomNavigationItems
import com.chacha.financeapp.core.presentation.common.theme.FinanceAppTheme

@Composable
fun AppNavigationBar(
    navController: NavHostController
) {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination

    NavigationBar(modifier = Modifier.fillMaxWidth()) {
        bottomNavigationItems.forEach { destination ->
            NavigationBarItem(
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
fun AppNavigationBarPreview() {
    FinanceAppTheme {
        AppNavigationBar(rememberNavController())
    }
}