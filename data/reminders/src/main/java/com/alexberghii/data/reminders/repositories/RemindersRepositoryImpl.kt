package com.alexberghii.data.reminders.repositories

import com.alexberghii.database.datasources.DatabaseDataSource
import com.alexberghii.database.entity.ReminderEntity
import com.alexberghii.domain.api.reminders.models.ReminderModel
import com.alexberghii.domain.api.reminders.repositories.RemindersRepository
import javax.inject.Inject


class RemindersRepositoryImpl @Inject constructor(private val databaseDataSource: DatabaseDataSource) : RemindersRepository {

    override suspend fun getReminders(): List<ReminderModel> = databaseDataSource.getReminderDao().getAll().map { it.toModel() }

    private fun ReminderEntity.toModel(): ReminderModel = ReminderModel(id, title, time, isEnabled)
}