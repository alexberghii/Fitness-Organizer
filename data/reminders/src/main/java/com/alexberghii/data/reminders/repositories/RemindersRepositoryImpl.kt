package com.alexberghii.data.reminders.repositories

import com.alexberghii.database.dao.ReminderDao
import com.alexberghii.database.datasources.DatabaseDataSource
import com.alexberghii.database.entity.ReminderEntity
import com.alexberghii.domain.api.reminders.models.ReminderModel
import com.alexberghii.domain.api.reminders.repositories.RemindersRepository
import javax.inject.Inject


class RemindersRepositoryImpl @Inject constructor(databaseDataSource: DatabaseDataSource) : RemindersRepository {

    private val reminderDao: ReminderDao = databaseDataSource.getReminderDao()

    override suspend fun getReminders(): List<ReminderModel> = reminderDao.getAll().map { it.toModel() }

    override suspend fun addReminder(reminder: ReminderModel) {
        reminderDao.insertOrReplace(reminder.toEntity())
    }

    override suspend fun deleteReminder(reminder: ReminderModel) {
        reminderDao.delete(reminder.toEntity())
    }

    override suspend fun updateReminderState(reminder: ReminderModel, isEnabled: Boolean) {
        reminderDao.insertOrReplace(reminder.toEntity(isEnabled))
    }

    override suspend fun editReminder(reminder: ReminderModel) {
        reminderDao.insertOrReplace(reminder.toEntity())
    }

    private fun ReminderEntity.toModel(): ReminderModel = ReminderModel(id, title, time, isEnabled)

    private fun ReminderModel.toEntity(): ReminderEntity = ReminderEntity(id, title, time, isEnabled)

    private fun ReminderModel.toEntity(isEnabled: Boolean): ReminderEntity = ReminderEntity(id, title, time, isEnabled)
}