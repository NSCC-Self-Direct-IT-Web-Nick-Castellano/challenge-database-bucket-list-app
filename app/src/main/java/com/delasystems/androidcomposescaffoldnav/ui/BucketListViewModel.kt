package com.delasystems.androidcomposescaffoldnav.ui

import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavController
import com.delasystems.androidcomposescaffoldnav.data.AppContainer
import com.delasystems.androidcomposescaffoldnav.data.datasources.BucketListDataSource
import com.delasystems.androidcomposescaffoldnav.data.models.BucketListItem
import com.delasystems.androidcomposescaffoldnav.data.repositories.BucketListItemRepository
import com.delasystems.androidcomposescaffoldnav.navigation.NavDestinations
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

// this holds the app state and makes modifications to it
// using the data layer's initial data source and model
@Suppress("UNREACHABLE_CODE")
class BucketListViewModel(
    private val bucketListItemRepository: BucketListItemRepository
) : ViewModel() {

    val appUiState: StateFlow<AppUiState> = bucketListItemRepository.getAllItemsStream().map {
        AppUiState(it)
    }.stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(5_000),
        initialValue = AppUiState()
    )

    fun addItem(title: String, description: String) {
        // use repository to insert the item
        viewModelScope.launch {
            bucketListItemRepository.insertItem(BucketListItem(title = title, description = description))
        }

    }


    fun toggleItemCompleteStatus(item: BucketListItem) {
        // use repository to update the item isCompleted status
        viewModelScope.launch {
            bucketListItemRepository.updateItem(item.copy(isCompleted = !item.isCompleted))
        }
    }


    fun deleteItem(item: BucketListItem) {
        // use repository to delete the item
        viewModelScope.launch {
            bucketListItemRepository.deleteItem(item)
        }
    }

    fun navigateToItemDetails(navController: NavController, item: BucketListItem) {
        val itemId = appUiState.value.bucketListItemList.indexOf(item)
        if (itemId != -1) {
            val route = "${NavDestinations.ItemDetailsScreen.route}/$itemId"
            navController.navigate(route)
        }
    }

    // get the list item by id
    fun getBucketListItemById(itemIndex: Int): BucketListItem? {
        if (itemIndex < appUiState.value.bucketListItemList.size) {
            return appUiState.value.bucketListItemList[itemIndex]
        } else {
            return BucketListItem(title = "", description = "")
        }
    }

    companion object {
        private const val TIMEOUT_MILLIS = 5_000L
    }
}

/**
 * Ui State for the whole app
 */
data class AppUiState (
    val bucketListItemList: List<BucketListItem> = listOf()
)