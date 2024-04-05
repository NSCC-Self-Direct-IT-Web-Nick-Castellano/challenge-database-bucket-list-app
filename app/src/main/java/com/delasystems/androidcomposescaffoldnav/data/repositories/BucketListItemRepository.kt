package com.delasystems.androidcomposescaffoldnav.data.repositories

import com.delasystems.androidcomposescaffoldnav.data.models.BucketListItem
import kotlinx.coroutines.flow.Flow

/**
 * Repository that provides insert, update, delete, and retrieve of [BucketListItem] from a given data source.
 */
interface BucketListItemRepository {
    /**
     * Retrieve all the items from the given data source.
     */
    fun getAllItemsStream(): Flow<List<BucketListItem>>

    /**
     * Retrieve an item from the given data source that matches with the [id].
     */
    fun getItemStream(id: Int): Flow<BucketListItem?>

    /**
     * Insert item in the data source
     */
    suspend fun insertItem(item: BucketListItem)

    /**
     * Delete item from the data source
     */
    suspend fun deleteItem(item: BucketListItem)

    /**
     * Update item in the data source
     */
    suspend fun updateItem(item: BucketListItem)
}