package com.delasystems.androidcomposescaffoldnav.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.ButtonColors
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.delasystems.androidcomposescaffoldnav.navigation.NavDestinations
import com.delasystems.androidcomposescaffoldnav.ui.BucketListViewModel

@Composable
fun ListItemDetailsScreen(navController: NavController, viewModel: BucketListViewModel, itemId: String?) {
    val selectedItem = itemId?.let { viewModel.getBucketListItemById(it.toInt()) }



    Column(
        modifier = Modifier
            .fillMaxSize(1F)
            .padding(16.dp, 24.dp),
        verticalArrangement = Arrangement.SpaceBetween,
    ) {
        if (selectedItem != null) {
            Column {
                Text(
                    text = selectedItem.title,
                    style = MaterialTheme.typography.h4,
                    modifier = Modifier.padding(bottom = 16.dp)
                )
                Text(
                    text = selectedItem.description,
                    style = MaterialTheme.typography.body1,
                    textAlign = TextAlign.Justify,
                    modifier = Modifier
                        .padding(bottom = 8.dp)

                )
            }
            Row (
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.fillMaxWidth()
            ) {
                Button(
                    onClick = { navController.navigateUp() },
                    modifier = Modifier


                ) {
                    Text(
                        text = "Back",
                        style = MaterialTheme.typography.h5
                    )
                }

                Button(
                    onClick = {
                        viewModel.deleteItem(item = selectedItem)

                        // Check if there are any remaining items in the list
                        if (viewModel.appUiState.value.bucketListItemList.isEmpty()) {
                            // If there are no items remaining, navigate back to the list screen
                            navController.popBackStack()
                        } else {
                            // If there are remaining items, navigate to the list screen
                            navController.navigate(NavDestinations.ListScreen.route)
                        }
                    },
                    colors = ButtonDefaults.buttonColors(backgroundColor = Color.Red),
                    modifier = Modifier

                ) {
                    Text(
                        text = "Delete Item",
                        style = MaterialTheme.typography.h5,
                        color = Color.White
                    )
                }
            }
        } else {
            Text("Item not found", style = MaterialTheme.typography.h5)
        }

        // Add a Spacer to push the content above the bottom navigation
        // bar so you don't overlap with it
        Spacer(modifier = Modifier.height(10.dp))
    }
}