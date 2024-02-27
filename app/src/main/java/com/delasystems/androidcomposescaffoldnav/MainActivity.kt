/*
Copyright (C) 2022 Roy Watson

Permission is hereby granted, free of charge, to any person obtaining a copy of this
software and associated documentation files (the "Software"), to deal in the Software
without restriction, including without limitation the rights to use, copy, modify, merge,
publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons
to whom the Software is furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all copies
or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED,
INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR
PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE
FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT,
TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE
OR OTHER DEALINGS IN THE SOFTWARE.
*/
package com.delasystems.androidcomposescaffoldnav

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.delasystems.androidcomposescaffoldnav.ui.theme.AndroidComposeScaffoldNavTheme
import com.delasystems.androidcomposescaffoldnav.navigation.FavoritesScreenList
import com.delasystems.androidcomposescaffoldnav.navigation.HistoryScreenList
import com.delasystems.androidcomposescaffoldnav.navigation.NavDestinations
import com.delasystems.androidcomposescaffoldnav.navigation.SearchScreenList
import com.delasystems.androidcomposescaffoldnav.ui.screens.*

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AndroidComposeScaffoldNavTheme {
                Surface(
                    modifier = Modifier
                        .fillMaxSize(),
                    color = MaterialTheme.colors.background,
                ) {
                    AndroidComposeScaffoldNavApp()
                }
            }
        }
    }
}

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
private fun AndroidComposeScaffoldNavApp() {
    val navController = rememberNavController()
    Scaffold(
        bottomBar = {
            BottomNavigation(
            ) {
                val backStackEntry by navController.currentBackStackEntryAsState()
                val currentRoute = backStackEntry?.destination?.route
                BottomNavigationItem(
                    onClick = { navController.navigate(NavDestinations.SearchScreen.route) },
                    icon = { Icon(painterResource(id = R.drawable.ic_baseline_search_24),
                        contentDescription = "Search")},
                    label = { Text(text = "Search")},
                    alwaysShowLabel = true,
                    selectedContentColor = Color.White,
                    unselectedContentColor = Color.White.copy(0.4f),
                    selected = SearchScreenList.contains(currentRoute)
                )
                BottomNavigationItem(
                    onClick = { navController.navigate(NavDestinations.HistoryScreen.route) },
                    icon = { Icon(painterResource(id = R.drawable.ic_baseline_history_24),
                        contentDescription = "History")},
                    label = { Text(text = "History")},
                    alwaysShowLabel = true,
                    selectedContentColor = Color.White,
                    unselectedContentColor = Color.White.copy(0.4f),
                    selected = HistoryScreenList.contains(currentRoute)
                )
                BottomNavigationItem(
                    onClick = { navController.navigate(NavDestinations.FavoritesScreen.route)},
                    icon = { Icon(painterResource(id = R.drawable.ic_baseline_favorite_border_24),
                        contentDescription = "Favorites")},
                    label = { Text(text = "Favorites")},
                    alwaysShowLabel = true,
                    selectedContentColor = Color.White,
                    unselectedContentColor = Color.White.copy(0.4f),
                    selected = FavoritesScreenList.contains(currentRoute)
                )
            }
        }
    ) {
        NavHost(
            modifier = Modifier.fillMaxSize(),
            navController = navController,
            startDestination = NavDestinations.SearchScreen.route
        ) {
            composable(route = NavDestinations.SearchScreen.route) {
                SearchScreen(navController)
            }
            composable(route = NavDestinations.HistoryScreen.route) {
                HistoryScreen(navController)
            }
            composable(route = NavDestinations.FavoritesScreen.route) {
                FavoritesScreen(navController)
            }

            composable(route = NavDestinations.SearchScreen2.route) {
                SearchScreen2(navController)
            }
            composable(route = NavDestinations.SearchScreen3.route) {
                SearchScreen3(navController)
            }

            composable(route = NavDestinations.HistoryScreen2.route) {
                HistoryScreen2(navController)
            }
            composable(route = NavDestinations.HistoryScreen3.route) {
                HistoryScreen3(navController)
            }

            composable(route = NavDestinations.FavoritesScreen2.route) {
                FavoritesScreen2(navController)
            }
            composable(route = NavDestinations.FavoritesScreen3.route) {
                FavoritesScreen3(navController)
            }
        }
    }
}