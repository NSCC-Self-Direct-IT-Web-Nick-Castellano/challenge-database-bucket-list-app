package com.delasystems.androidcomposescaffoldnav.ui

import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.delasystems.androidcomposescaffoldnav.data.BucketListDataSource
import com.delasystems.androidcomposescaffoldnav.data.BucketListItemModel
import java.lang.Exception

// this holds the app state and makes modifications to it
// using the data layer's initial data source and model
@Suppress("UNREACHABLE_CODE")
class BucketListViewModel : ViewModel() {
    private val _bucketListItems = mutableStateOf(listOf<BucketListItemModel>())
    val bucketListItems: MutableState<List<BucketListItemModel>> = _bucketListItems

    init {
        // Initialize UI state with default items from the data source
        initializeBucketListItems()
    }

    private fun initializeBucketListItems() {
        _bucketListItems.value = BucketListDataSource.getDefaultBucketListItems()
    }

    fun addItem(title: String, description: String) {
        val newItem = BucketListItemModel(title = title, description = description)
        _bucketListItems.value = _bucketListItems.value + newItem
    }

    fun completeItem(item: BucketListItemModel) {
        val updatedItems = _bucketListItems.value.map {
            if (it == item) {
                it.copy(isCompleted = true)
            } else {
                it
            }
        }
        _bucketListItems.value = updatedItems
    }

    fun unCompleteItem(item: BucketListItemModel) {
        val updatedItems = _bucketListItems.value.map {
            if (it == item) {
                it.copy(isCompleted = false)
            } else {
                it
            }
        }
        _bucketListItems.value = updatedItems
    }

    fun toggleItemCompleteStatus(item: BucketListItemModel) {
        val updatedItems = _bucketListItems.value.map {
            if (it == item) {
                it.copy(isCompleted = !it.isCompleted)
            } else {
                it
            }
        }
        _bucketListItems.value = updatedItems
    }
    fun deleteItem(item: BucketListItemModel) {
        _bucketListItems.value = _bucketListItems.value.filterNot { it == item }
    }
}