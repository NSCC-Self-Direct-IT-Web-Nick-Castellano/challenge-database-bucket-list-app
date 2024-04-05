package com.delasystems.androidcomposescaffoldnav.data.models

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

@Dao
interface BucketListItemDao {
    /**
     * Insert a single bucket list item
     */
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(bucketListItem: BucketListItem)

    /**
     * Update a single bucket list item by item object
     */
    @Update
    suspend fun update(bucketListItem: BucketListItem)

    /**
     * Delete a single bucket list item by item object
     */
    @Delete
    suspend fun delete(bucketListItem: BucketListItem)

    /**
     * Get a list of all the bucket list items
     */
    @Query("SELECT * from bucket_list_items WHERE id = :id")
    fun getItem(id: Int): Flow<BucketListItem>

}