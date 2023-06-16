package com.akbar.capstone2.ui.component

import  androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.akbar.capstone2.R
import com.akbar.capstone2.navigation.NavigationItem
import com.akbar.capstone2.navigation.Screen

@Composable
fun BottomBar(
    navController: NavHostController,
    modifier: Modifier = Modifier,
) {
    NavigationBar(
        contentColor = MaterialTheme.colorScheme.primary,
        containerColor = MaterialTheme.colorScheme.surface,
        modifier = modifier
            .padding(16.dp)
            .clip(RoundedCornerShape(16.dp))
    ) {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route
        val navigationItems = listOf(
            NavigationItem(
                icon = R.drawable.home_3,
                title = stringResource(R.string.menu_home),
                screen = Screen.Home,

                ),
            NavigationItem(
                icon = R.drawable.plant_recomendation_disable,
                title = stringResource(R.string.menu_recommend),
                screen = Screen.Recommend,
            ),
            NavigationItem(
                icon = R.drawable.scan_plant_disable,
                title = stringResource(R.string.menu_scan),
                screen = Screen.PestAnalysis
            ),
            NavigationItem(
                icon = R.drawable.shoppingcart,
                title = stringResource(R.string.menu_market),
                screen = Screen.Market
            ),
        )
        NavigationBar {
            navigationItems.map { item ->
                NavigationBarItem(
                    icon = {
                        Icon(
                            painter = painterResource(item.icon),
                            contentDescription = item.title,
                            modifier = modifier.size(24.dp),
                        )
                    },
                    label = {
                            Text(
                                text = (item.title),
                                fontSize = 10.sp,
                            )
                    },
                    selected = currentRoute == item.screen.route,
                    onClick = {
                        navController.navigate(item.screen.route) {
                            popUpTo(navController.graph.findStartDestination().id) {
                                saveState = true
                            }
                            restoreState = true
                            launchSingleTop = true
                        }
                    }
                )
            }
        }
    }
}
