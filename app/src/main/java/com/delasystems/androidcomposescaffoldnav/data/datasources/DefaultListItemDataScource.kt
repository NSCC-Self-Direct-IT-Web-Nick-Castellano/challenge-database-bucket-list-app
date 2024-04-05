package com.delasystems.androidcomposescaffoldnav.data.datasources

import com.delasystems.androidcomposescaffoldnav.data.models.BucketListItem

object BucketListDataSource {
    private val defaultBucketListItems = listOf(
        BucketListItem(
            title = "Visit the Grand Canyon",
            description = "Take a trip to the Grand Canyon and marvel at its beauty.",
            isCompleted = false
        ),
        BucketListItem(
            title = "Learn to play the guitar",
            description = "Take guitar lessons and learn to play your favorite songs.",
            isCompleted = true
        ),
        BucketListItem(
            title = "Travel to Japan",
            description = "Explore the culture, food, and sights of Japan.",
            isCompleted = false
        ),
        BucketListItem(
            title = "Read 50 books",
            description = "Challenge yourself to read 50 books in a year.",
            isCompleted = true
        ),
        BucketListItem(
            title = "Start a garden",
            description = "Grow your own fruits, vegetables, and flowers.",
            isCompleted = false
        )
    )

    fun getDefaultBucketListItems(): List<BucketListItem> {
        return defaultBucketListItems
    }
}