package com.delasystems.androidcomposescaffoldnav.data

import android.content.Context
import com.delasystems.androidcomposescaffoldnav.data.repositories.BucketListItemRepository
import com.delasystems.androidcomposescaffoldnav.data.repositories.OfflineBucketListItemRepository

interface AppContainer {
    val bucketListItemRepository: BucketListItemRepository
}

class DefaultAppContainer(
    private val context: Context
) : AppContainer {

    private val database = BucketListDatabase.getDatabase(context)

    override val bucketListItemRepository: BucketListItemRepository by lazy {
        // OfflineBucketListItemRepository(bucketListItemDao)
        OfflineBucketListItemRepository(
            database.bucketListItemDao()
        )
    }

}