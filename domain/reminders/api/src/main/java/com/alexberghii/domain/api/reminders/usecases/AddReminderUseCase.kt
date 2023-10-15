package com.alexberghii.domain.api.reminders.usecases

import com.alexberghii.domain.api.reminders.models.ReminderModel


interface AddReminderUseCase {

    suspend operator fun invoke(reminder: ReminderModel)
}