package com.delasystems.androidcomposescaffoldnav.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.delasystems.androidcomposescaffoldnav.data.BucketListItemModel
import com.delasystems.androidcomposescaffoldnav.ui.BucketListViewModel

@Composable
fun ListItemDetailsScreen(navController: NavController, viewModel: BucketListViewModel, itemId: String?) {
    val selectedItem = itemId?.let { viewModel.getBucketListItemById(it.toInt()) }

    Column(
        modifier = Modifier
            .fillMaxSize(1F)
            .padding(16.dp, 24.dp),
        verticalArrangement = Arrangement.SpaceBetween,
//        horizontalAlignment = Alignment.CenterHorizontally
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
            Button(
                onClick = { navController.navigateUp() },
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)

            ) {
                Text(
                    text = "Back",
                    style = MaterialTheme.typography.h5
                )
            }
        } else {
            Text("Item not found", style = MaterialTheme.typography.h5)
        }

        // Add a Spacer to push the content above the bottom navigation
        // bar so you don't overlap with it
        Spacer(modifier = Modifier.height(10.dp))
    }
}