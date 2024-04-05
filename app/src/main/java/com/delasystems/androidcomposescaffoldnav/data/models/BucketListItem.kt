package com.delasystems.androidcomposescaffoldnav.data.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "bucket_list_items")
data class BucketListItem(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,

    val title: String,
    val description: String,
    val isCompleted: Boolean = false,

)