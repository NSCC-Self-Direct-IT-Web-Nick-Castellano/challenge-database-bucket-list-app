package com.delasystems.androidcomposescaffoldnav.ui

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.navigation.NavController
import com.delasystems.androidcomposescaffoldnav.data.datasources.BucketListDataSource
import com.delasystems.androidcomposescaffoldnav.data.models.BucketListItem
import com.delasystems.androidcomposescaffoldnav.navigation.NavDestinations

// this holds the app state and makes modifications to it
// using the data layer's initial data source and model
@Suppress("UNREACHABLE_CODE")
class BucketListViewModel : ViewModel() {
    private val _bucketListItems = mutableStateOf(listOf<BucketListItem>())
    val bucketListItems: MutableState<List<BucketListItem>> = _bucketListItems

    init {
        // Initialize UI state with default items from the data source
        initializeBucketListItems()
    }

    private fun initializeBucketListItems() {
        _bucketListItems.value = BucketListDataSource.getDefaultBucketListItems()
    }

    fun addItem(title: String, description: String) {
        val newItem = BucketListItem(title = title, description = description)
        _bucketListItems.value = _bucketListItems.value + newItem
    }

    fun completeItem(item: BucketListItem) {
        val updatedItems = _bucketListItems.value.map {
            if (it == item) {
                it.copy(isCompleted = true)
            } else {
                it
            }
        }
        _bucketListItems.value = updatedItems
    }

    fun unCompleteItem(item: BucketListItem) {
        val updatedItems = _bucketListItems.value.map {
            if (it == item) {
                it.copy(isCompleted = false)
            } else {
                it
            }
        }
        _bucketListItems.value = updatedItems
    }

    fun toggleItemCompleteStatus(item: BucketListItem) {
        val updatedItems = _bucketListItems.value.map {
            if (it == item) {
                it.copy(isCompleted = !it.isCompleted)
            } else {
                it
            }
        }
        _bucketListItems.value = updatedItems
    }
    fun deleteItem(item: BucketListItem) {
        _bucketListItems.value = _bucketListItems.value.filterNot { it == item }
    }

    fun navigateToItemDetails(navController: NavController, item: BucketListItem) {
        val itemId = bucketListItems.value.indexOf(item)
        if (itemId != -1) {
            val route = "${NavDestinations.ItemDetailsScreen.route}/$itemId"
            navController.navigate(route)
        }
    }

    // get the list item by id
    fun getBucketListItemById(itemIndex: Int): BucketListItem? {
        if (itemIndex < bucketListItems.value.size) {
            return bucketListItems.value.get(itemIndex)
        } else {
            return BucketListItem(title = "", description = "")
        }
    }
}