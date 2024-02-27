package com.delasystems.androidcomposescaffoldnav.ui.components

import androidx.compose.foundation.background
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavController
import com.delasystems.androidcomposescaffoldnav.R
import com.delasystems.androidcomposescaffoldnav.navigation.NavDestinations

@Composable
fun TopNavigationBar(
    currentRoute: String,
    navController: NavController
) {
    TopAppBar (
        title = {
            // if the route is the detail page, then have a different title to the current route
            // because we are dynamically displaying that
            if (currentRoute.contains(NavDestinations.ItemDetailsScreen.route)) {
                Text("List Item Detail")
            } else {
                Text(currentRoute)
            }
        },
        modifier = Modifier
            .background(MaterialTheme.colors.primary)
        ,
        // this button returns to the previous page
        navigationIcon = {
            IconButton(onClick = { navController.navigateUp() }) {
                Icon(
                    imageVector = Icons.Filled.ArrowBack,
                    contentDescription = stringResource(id = R.string.back_button)
                )
            }
        }
    )
}