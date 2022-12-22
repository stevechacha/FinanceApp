package com.chacha.financeapp.core.presentation.bottomnav

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.chacha.financeapp.core.presentation.common.navigation.BottomBarScreen
import com.chacha.financeapp.core.presentation.common.navigation.bottomNavigationItems
import com.chacha.financeapp.core.presentation.common.theme.FinanceAppTheme

@SuppressLint("RememberReturnType")
@Composable
fun BottomNavigationBar(navController: NavHostController) {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination

    BottomAppBar (
        containerColor = Color.Transparent,
    ){
        bottomNavigationItems.forEach { destination ->
            NavigationBarItem(
                selected = currentDestination?.hierarchy?.any { it.route == destination.route } == true,
                icon = {
                    Icon(
                        painter = painterResource(id = destination.icon),
                        contentDescription = destination.title,
                        )
                    },
                label = { Text(text = destination.title) },
                alwaysShowLabel = true,
                onClick = {
                    navController.navigate(destination.route) {
                        popUpTo(BottomBarScreen.Home.route) { inclusive = true }
                        launchSingleTop = true
                        restoreState = true
                        }
                    },
                colors = NavigationBarItemDefaults.colors(
                    selectedIconColor = Color.Magenta,
                    unselectedIconColor = MaterialTheme.colorScheme.onBackground,
                    selectedTextColor = Color.Magenta,
                    unselectedTextColor = MaterialTheme.colorScheme.onBackground
                    ),
                )
            }
    }
}


@Preview
@Composable
fun BottomNavigationPreview() {
    FinanceAppTheme {
        BottomNavigationBar(rememberNavController())
    }
}