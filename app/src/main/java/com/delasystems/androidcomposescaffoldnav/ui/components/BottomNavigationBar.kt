package com.delasystems.androidcomposescaffoldnav.ui.components

import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.List
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.delasystems.androidcomposescaffoldnav.navigation.NavDestinations

@Composable
fun BottomNavigationBar(
    navController: NavHostController = rememberNavController(),
    currentRoute: String
) {
    BottomNavigation(
    ) {

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