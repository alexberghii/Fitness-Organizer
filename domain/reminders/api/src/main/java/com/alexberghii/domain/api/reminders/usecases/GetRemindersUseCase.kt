package com.alexberghii.domain.api.reminders.usecases

import com.alexberghii.domain.api.reminders.models.ReminderModel


interface GetRemindersUseCase {

    suspend operator fun invoke(): List<ReminderModel>
}