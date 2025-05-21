package com.srdc.plantapp.data.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.srdc.plantapp.data.local.dao.CategoryDao

@Database(
    entities = [CategoryEntity::class],
    version = 1
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun categoryDao(): CategoryDao
}
