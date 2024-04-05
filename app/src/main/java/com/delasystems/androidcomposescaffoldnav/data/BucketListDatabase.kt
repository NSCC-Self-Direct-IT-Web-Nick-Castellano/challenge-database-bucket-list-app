package com.delasystems.androidcomposescaffoldnav.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.delasystems.androidcomposescaffoldnav.data.models.BucketListItem
import com.delasystems.androidcomposescaffoldnav.data.models.BucketListItemDao

@Database(entities = [BucketListItem::class], version = 1, exportSchema = false)
abstract class BucketListDatabase : RoomDatabase() {
    abstract fun bucketListItemDao() : BucketListItemDao

    companion object {
        @Volatile
        private var Instance: BucketListDatabase? = null

        fun getDatabase(context: Context): BucketListDatabase {
            return Instance ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context,
                    BucketListDatabase::class.java,
                    "bucket_list_database"
                )
//                    .fallbackToDestructiveMigration()
                    .build()
                Instance = instance
                instance

            }
        }
    }
}