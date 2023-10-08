package com.alexberghii.domain.impl.reminders.usecases

import com.alexberghii.domain.api.reminders.models.ReminderModel
import com.alexberghii.domain.api.reminders.repositories.RemindersRepository
import com.alexberghii.domain.api.reminders.usecases.GetRemindersUseCase
import javax.inject.Inject


class GetRemindersUseCaseImpl @Inject constructor(private val remindersRepository: RemindersRepository) : GetRemindersUseCase {

    override suspend fun invoke(): List<ReminderModel> = remindersRepository.getReminders()
}