package com.alexberghii.domain.impl.reminders.usecases

import com.alexberghii.domain.api.reminders.models.ReminderModel
import com.alexberghii.domain.api.reminders.repositories.RemindersRepository
import com.alexberghii.domain.api.reminders.usecases.DeleteReminderUseCase
import javax.inject.Inject


class DeleteReminderUseCaseImpl @Inject constructor(private val remindersRepository: RemindersRepository) : DeleteReminderUseCase {

    override suspend fun invoke(reminder: ReminderModel) {
        remindersRepository.deleteReminder(reminder)
    }
}