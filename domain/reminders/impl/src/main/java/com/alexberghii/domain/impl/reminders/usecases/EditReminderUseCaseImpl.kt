package com.alexberghii.domain.impl.reminders.usecases

import com.alexberghii.domain.api.reminders.models.ReminderModel
import com.alexberghii.domain.api.reminders.repositories.RemindersRepository
import com.alexberghii.domain.api.reminders.usecases.EditReminderUseCase
import javax.inject.Inject


class EditReminderUseCaseImpl @Inject constructor(private val remindersRepository: RemindersRepository) : EditReminderUseCase {

    override suspend fun invoke(reminder: ReminderModel) {
        remindersRepository.addReminder(reminder)
    }
}