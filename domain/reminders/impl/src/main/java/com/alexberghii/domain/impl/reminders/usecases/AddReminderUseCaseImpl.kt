package com.alexberghii.domain.impl.reminders.usecases

import com.alexberghii.domain.api.reminders.models.ReminderModel
import com.alexberghii.domain.api.reminders.repositories.RemindersRepository
import com.alexberghii.domain.api.reminders.usecases.AddReminderUseCase
import javax.inject.Inject


class AddReminderUseCaseImpl @Inject constructor(private val remindersRepository: RemindersRepository) : AddReminderUseCase {

    override suspend fun invoke(reminder: ReminderModel) {
        remindersRepository.addReminder(reminder)
    }
}