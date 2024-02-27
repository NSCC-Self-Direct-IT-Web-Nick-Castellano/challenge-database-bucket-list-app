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

@Composable
fun TopNavigationBar(
    currentRoute: String,
    navController: NavController
) {
    TopAppBar (
        title = { Text(currentRoute) },
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