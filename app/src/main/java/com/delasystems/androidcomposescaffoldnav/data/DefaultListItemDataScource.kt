package com.delasystems.androidcomposescaffoldnav.data

object BucketListDataSource {
    private val defaultBucketListItems = listOf(
        BucketListItemModel(
            title = "Visit the Grand Canyon",
            description = "Take a trip to the Grand Canyon and marvel at its beauty.",
            isCompleted = false
        ),
//        BucketListItemModel(
//            title = "Learn to play the guitar",
//            description = "Take guitar lessons and learn to play your favorite songs.",
//            isCompleted = true
//        ),
//        BucketListItemModel(
//            title = "Travel to Japan",
//            description = "Explore the culture, food, and sights of Japan.",
//            isCompleted = false
//        ),
//        BucketListItemModel(
//            title = "Read 50 books",
//            description = "Challenge yourself to read 50 books in a year.",
//            isCompleted = true
//        ),
//        BucketListItemModel(
//            title = "Start a garden",
//            description = "Grow your own fruits, vegetables, and flowers.",
//            isCompleted = false
//        )
    )

    fun getDefaultBucketListItems(): List<BucketListItemModel> {
        return defaultBucketListItems
    }
}