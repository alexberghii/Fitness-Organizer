package com.alexberghii.domain.impl.reminders.usecases

import com.alexberghii.domain.api.reminders.models.ReminderModel
import com.alexberghii.domain.api.reminders.repositories.RemindersRepository
import com.alexberghii.domain.api.reminders.usecases.UpdateReminderStateUseCase
import javax.inject.Inject


class UpdateReminderStateUseCaseImpl @Inject constructor(private val remindersRepository: RemindersRepository) : UpdateReminderStateUseCase {

    override suspend fun invoke(reminder: ReminderModel, isEnabled: Boolean) {
        remindersRepository.updateReminderState(reminder, isEnabled)
    }
}