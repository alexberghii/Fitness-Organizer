package com.alexberghii.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.alexberghii.database.dao.ReminderDao
import com.alexberghii.database.entity.ReminderEntity


@Database(
    version = 1,
    entities = [
        ReminderEntity::class
    ],
    exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {

    abstract fun reminderDao(): ReminderDao

    companion object {
        fun create(context: Context): AppDatabase =
            Room.databaseBuilder(context, AppDatabase::class.java, DATABASE_NAME).build()

        private const val DATABASE_NAME = "appdatabase.name"
    }
}