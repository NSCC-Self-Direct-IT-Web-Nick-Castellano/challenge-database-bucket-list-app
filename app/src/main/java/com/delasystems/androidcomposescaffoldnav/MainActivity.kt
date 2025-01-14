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
package com.delasystems.androidcomposescaffoldnav

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import com.delasystems.androidcomposescaffoldnav.data.DefaultAppContainer
import com.delasystems.androidcomposescaffoldnav.ui.AndroidComposeScaffoldNavApp
import com.delasystems.androidcomposescaffoldnav.ui.BucketListViewModel
import com.delasystems.androidcomposescaffoldnav.ui.theme.AndroidComposeScaffoldNavTheme

class MainActivity : ComponentActivity() {

    // set the viewmodel
//    private lateinit var viewModel: BucketListViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // create an instance of BucketListAppContainer
        val appContainer = (application as BucketListApplication).container
        // initialize the viewmodel
//        viewModel = BucketListViewModel(appContainer.bucketListItemRepository)


        setContent {
            AndroidComposeScaffoldNavTheme {
                Surface(
                    modifier = Modifier
                        .fillMaxSize(),
                    color = MaterialTheme.colors.background,
                ) {
                    AndroidComposeScaffoldNavApp(
                        appContainer = appContainer
                    )
                }
            }
        }
    }
}
