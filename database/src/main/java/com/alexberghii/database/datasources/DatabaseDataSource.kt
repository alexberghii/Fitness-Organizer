package com.alexberghii.database.datasources

import com.alexberghii.database.AppDatabase
import com.alexberghii.database.dao.ReminderDao
import javax.inject.Inject


class DatabaseDataSource @Inject constructor(private val db: AppDatabase) {

    fun getReminderDao(): ReminderDao = db.reminderDao()
}