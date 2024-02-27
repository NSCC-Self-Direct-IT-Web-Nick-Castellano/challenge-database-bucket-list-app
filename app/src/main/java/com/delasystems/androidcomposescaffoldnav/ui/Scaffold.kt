package com.delasystems.androidcomposescaffoldnav.ui

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.List
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.delasystems.androidcomposescaffoldnav.R
//import com.delasystems.androidcomposescaffoldnav.navigation.FavoritesScreenList
//import com.delasystems.androidcomposescaffoldnav.navigation.HistoryScreenList
import com.delasystems.androidcomposescaffoldnav.navigation.NavDestinations
import com.delasystems.androidcomposescaffoldnav.ui.components.BottomNavigationBar
import com.delasystems.androidcomposescaffoldnav.ui.components.TopNavigationBar
import com.delasystems.androidcomposescaffoldnav.ui.screens.BucketListScreen
import com.delasystems.androidcomposescaffoldnav.ui.screens.ListItemDetailsScreen
import com.delasystems.androidcomposescaffoldnav.ui.screens.NewListItemScreen



@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun AndroidComposeScaffoldNavApp() {
    val navController = rememberNavController()
    val backStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = backStackEntry?.destination?.route

    // initialize the viewModel
    val viewModel: BucketListViewModel = viewModel()

    Scaffold(
        bottomBar = {
            BottomNavigationBar(
                navController = navController,
                currentRoute = currentRoute.toString()
            )
        },
        topBar = {
            TopNavigationBar(
                currentRoute = currentRoute.toString(),
                navController = navController
            )
        }
    ) {
        NavHost(
            modifier = Modifier.fillMaxSize(),
            navController = navController,
            startDestination = NavDestinations.ListScreen.route
        ) {
            composable(route = NavDestinations.ListScreen.route) {
                BucketListScreen(navController=navController, viewModel = viewModel)
            }
            composable(route = NavDestinations.NewItemScreen.route) {
                NewListItemScreen(navController=navController, viewModel = viewModel)
            }
            composable(route = NavDestinations.ItemDetailsScreen.route) {
                ListItemDetailsScreen(navController)
            }
        }
    }
}