package com.alexberghii.domain.api.reminders.repositories

import com.alexberghii.domain.api.reminders.models.ReminderModel


interface RemindersRepository {

    suspend fun getReminders(): List<ReminderModel>
}