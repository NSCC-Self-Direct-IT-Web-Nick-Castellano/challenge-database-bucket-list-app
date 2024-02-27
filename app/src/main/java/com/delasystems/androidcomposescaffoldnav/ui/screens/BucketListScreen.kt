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
package com.delasystems.androidcomposescaffoldnav.ui.screens

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Checkbox
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.core.os.bundleOf
import androidx.navigation.NavController
import androidx.navigation.Navigator
import com.delasystems.androidcomposescaffoldnav.data.BucketListItemModel
import com.delasystems.androidcomposescaffoldnav.navigation.NavDestinations
import com.delasystems.androidcomposescaffoldnav.ui.BucketListViewModel
import com.delasystems.androidcomposescaffoldnav.ui.components.BucketListItemRow

@Composable
fun BucketListScreen(
    navController: NavController,
    viewModel: BucketListViewModel
) {
    // use the view model to initialize the data and observe the
    // bucket list changes
    val items = viewModel.bucketListItems.value

    LazyColumn (
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Transparent),
    ) {

        items(items = items, itemContent = {item ->
            // get the item id
            BucketListItemRow(
                item = item,
                onCheckboxChange = { viewModel.toggleItemCompleteStatus(item) },
                // we use this custom route to dynamically navigate to the detail page of list item
                onItemClick = {
//                    Log.d("UI_Event", "Clicked on a list item")

                    viewModel.navigateToItemDetails(
                        navController = navController,
                        item = item
                    )
                }
            )
        })
    }

}