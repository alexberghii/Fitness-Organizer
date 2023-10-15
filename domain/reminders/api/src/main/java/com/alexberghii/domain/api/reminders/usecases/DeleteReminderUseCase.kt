package com.alexberghii.domain.api.reminders.usecases

import com.alexberghii.domain.api.reminders.models.ReminderModel


interface DeleteReminderUseCase {

    suspend operator fun invoke(reminder: ReminderModel)
}