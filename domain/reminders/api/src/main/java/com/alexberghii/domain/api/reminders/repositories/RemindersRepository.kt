package com.alexberghii.domain.api.reminders.repositories

import com.alexberghii.domain.api.reminders.models.ReminderModel


interface RemindersRepository {

    suspend fun getReminders(): List<ReminderModel>

    suspend fun addReminder(reminder: ReminderModel)

    suspend fun deleteReminder(reminder: ReminderModel)

    suspend fun updateReminderState(reminder: ReminderModel, isEnabled: Boolean)

    suspend fun editReminder(reminder: ReminderModel)
}