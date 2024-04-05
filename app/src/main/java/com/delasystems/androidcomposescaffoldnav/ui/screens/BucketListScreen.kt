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

import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController
import com.delasystems.androidcomposescaffoldnav.ui.BucketListViewModel
import com.delasystems.androidcomposescaffoldnav.ui.components.BucketListItemRow

@SuppressLint("StateFlowValueCalledInComposition")
@Composable
fun BucketListScreen(
    navController: NavController,
    viewModel: BucketListViewModel
) {
    // use the view model to initialize the data and observe the
    val appViewModelState by viewModel.appUiState.collectAsState()


    LazyColumn (
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Transparent),
    ) {

        items(items = appViewModelState.bucketListItemList, key = { item -> item.id },
            itemContent = {item ->
            // get the item id
            BucketListItemRow(
                item = item,
                onCheckboxChange = { viewModel.toggleItemCompleteStatus(item) },
                // we use this custom route to dynamically navigate to the detail page of list item
                onItemClick = {

                    viewModel.navigateToItemDetails(
                        navController = navController,
                        item = item
                    )
                }
            )
        })
    }

}