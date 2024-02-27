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

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.delasystems.androidcomposescaffoldnav.navigation.NavDestinations
import com.delasystems.androidcomposescaffoldnav.ui.BucketListViewModel

@Composable
fun NewListItemScreen(
    navController: NavController,
    viewModel: BucketListViewModel
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text(
            text = "New List Item",
            style = MaterialTheme.typography.h4,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        // Form content
        var title by remember { mutableStateOf("") }
        var description by remember { mutableStateOf("") }

        OutlinedTextField(
            value = title,
            onValueChange = {
                // only change the text if the value has not surpassed
                // the limit
                if (it.length <= MAX_TITLE_LENGTH) {
                    title = it
                }
            },
            label = { Text("Title") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))


        TextField(
            value = description,
            onValueChange = {
                // only change the text if the value has not surpassed
                // the limit
                if (it.length <= MAX_DESCRIPTION_LENGTH) {
                    description = it
                }
            },
            label = { Text("Description") },
            modifier = Modifier.fillMaxWidth(),
            // Set maximum number of lines
            maxLines = 5,


        )

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = {
                // Handle button click (e.g., save new item)
                viewModel.addItem(
                    title=title,
                    description=description
                )

                // after we are done submitting, return to the bucket list screen
                navController.navigate(
                    NavDestinations.ListScreen.route
                )


            },
            modifier = Modifier.align(Alignment.End)
        ) {
            Text("Save")
        }
    }
}

private const val MAX_DESCRIPTION_LENGTH = 200 // Maximum number of characters allowed in the description
private const val MAX_TITLE_LENGTH = 50 // Maximum number of characters allowed in the description
