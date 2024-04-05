package com.delasystems.androidcomposescaffoldnav.data.repositories

import com.delasystems.androidcomposescaffoldnav.data.models.BucketListItem
import com.delasystems.androidcomposescaffoldnav.data.models.BucketListItemDao
import kotlinx.coroutines.flow.Flow

class OfflineBucketListItemRepository(
    private val bucketListItemDao: BucketListItemDao
) : BucketListItemRepository {
    override fun getAllItemsStream(): Flow<List<BucketListItem>> {
        return bucketListItemDao.getAllItems()
    }

    override fun getItemStream(id: Int): Flow<BucketListItem?> {
        return bucketListItemDao.getItem(id)
    }

    override suspend fun insertItem(item: BucketListItem) {
        bucketListItemDao.insert(item)
    }

    override suspend fun deleteItem(item: BucketListItem) {
        bucketListItemDao.delete(item)
    }

    override suspend fun updateItem(item: BucketListItem) {
        bucketListItemDao.update(item)
    }
}