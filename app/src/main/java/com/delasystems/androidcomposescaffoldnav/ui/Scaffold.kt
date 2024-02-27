package com.delasystems.androidcomposescaffoldnav.ui

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.List
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.delasystems.androidcomposescaffoldnav.R
//import com.delasystems.androidcomposescaffoldnav.navigation.FavoritesScreenList
//import com.delasystems.androidcomposescaffoldnav.navigation.HistoryScreenList
import com.delasystems.androidcomposescaffoldnav.navigation.NavDestinations
import com.delasystems.androidcomposescaffoldnav.ui.screens.BucketListScreen
import com.delasystems.androidcomposescaffoldnav.ui.screens.ListItemDetailsScreen
import com.delasystems.androidcomposescaffoldnav.ui.screens.NewListItemScreen


@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun AndroidComposeScaffoldNavApp() {
    val navController = rememberNavController()
    Scaffold(
        bottomBar = {
            BottomNavigation(
            ) {
                val backStackEntry by navController.currentBackStackEntryAsState()
                val currentRoute = backStackEntry?.destination?.route


                BottomNavigationItem(
                    onClick = { navController.navigate(NavDestinations.ListScreen.route)},
                    icon = { Icon(
                        Icons.Filled.List,
                        contentDescription = "Bucket List")
                    },
                    label = { Text(text = "Bucket List") },
                    alwaysShowLabel = true,
                    selectedContentColor = Color.White,
                    unselectedContentColor = Color.White.copy(0.4f),
                    selected = currentRoute == NavDestinations.ListScreen.route
                )

                BottomNavigationItem(
                    onClick = { navController.navigate(NavDestinations.NewItemScreen.route)},
                    icon = { Icon(
                        Icons.Filled.Add,
                        contentDescription = "New Item")
                    },
                    label = { Text(text = "New Item") },
                    alwaysShowLabel = true,
                    selectedContentColor = Color.White,
                    unselectedContentColor = Color.White.copy(0.4f),
                    selected = currentRoute == NavDestinations.ListScreen.route
                )
            }
        }
    ) {
        NavHost(
            modifier = Modifier.fillMaxSize(),
            navController = navController,
            startDestination = NavDestinations.ListScreen.route
        ) {
            composable(route = NavDestinations.ListScreen.route) {
                BucketListScreen(navController)
            }
            composable(route = NavDestinations.NewItemScreen.route) {
                NewListItemScreen(navController)
            }
            composable(route = NavDestinations.ItemDetailsScreen.route) {
                ListItemDetailsScreen(navController)
            }
        }
    }
}