package com.delasystems.androidcomposescaffoldnav.ui

import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.delasystems.androidcomposescaffoldnav.data.AppContainer
import com.delasystems.androidcomposescaffoldnav.navigation.NavDestinations
import com.delasystems.androidcomposescaffoldnav.ui.components.BottomNavigationBar
import com.delasystems.androidcomposescaffoldnav.ui.components.TopNavigationBar
import com.delasystems.androidcomposescaffoldnav.ui.screens.BucketListScreen
import com.delasystems.androidcomposescaffoldnav.ui.screens.ListItemDetailsScreen
import com.delasystems.androidcomposescaffoldnav.ui.screens.NewListItemScreen


@SuppressLint("UnusedMaterialScaffoldPaddingParameter", "StateFlowValueCalledInComposition")
@Composable
fun AndroidComposeScaffoldNavApp(
     appContainer: AppContainer
//    viewModel: BucketListViewModel
) {
    val navController = rememberNavController()
    val backStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = backStackEntry?.destination?.route

    // initialize the viewModel
    val viewModel = BucketListViewModel(appContainer.bucketListItemRepository)

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

            // this screen is being dynamically displayed, so we need to pass extra
            // arguments to do so
            composable(
                route = "${NavDestinations.ItemDetailsScreen.route}/{itemId}",
                arguments = listOf(navArgument("itemId") { type = NavType.StringType })
            ) { backStackEntry ->
                val itemId = backStackEntry.arguments?.getString("itemId")

                if (viewModel.appUiState.value.bucketListItemList.isNotEmpty() && itemId != null) {
                    ListItemDetailsScreen(navController, viewModel, itemId)
                } else {
                    Text("")
                }
            }
        }
    }
}