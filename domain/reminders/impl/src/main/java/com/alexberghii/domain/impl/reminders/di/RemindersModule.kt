package com.alexberghii.domain.impl.reminders.di

import com.alexberghii.domain.api.reminders.usecases.AddReminderUseCase
import com.alexberghii.domain.api.reminders.usecases.DeleteReminderUseCase
import com.alexberghii.domain.api.reminders.usecases.EditReminderUseCase
import com.alexberghii.domain.api.reminders.usecases.GetRemindersUseCase
import com.alexberghii.domain.api.reminders.usecases.UpdateReminderStateUseCase
import com.alexberghii.domain.impl.reminders.usecases.AddReminderUseCaseImpl
import com.alexberghii.domain.impl.reminders.usecases.DeleteReminderUseCaseImpl
import com.alexberghii.domain.impl.reminders.usecases.EditReminderUseCaseImpl
import com.alexberghii.domain.impl.reminders.usecases.GetRemindersUseCaseImpl
import com.alexberghii.domain.impl.reminders.usecases.UpdateReminderStateUseCaseImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent


@Module
@InstallIn(ViewModelComponent::class)
abstract class RemindersModule {

    @Binds
    abstract fun bindGetRemindersUseCase(useCaseImpl: GetRemindersUseCaseImpl): GetRemindersUseCase

    @Binds
    abstract fun bindAddReminderUseCase(useCaseImpl: AddReminderUseCaseImpl): AddReminderUseCase

    @Binds
    abstract fun bindDeleteReminderUseCase(useCaseImpl: DeleteReminderUseCaseImpl): DeleteReminderUseCase

    @Binds
    abstract fun bindUpdateReminderStateUseCase(useCaseImpl: UpdateReminderStateUseCaseImpl): UpdateReminderStateUseCase

    @Binds
    abstract fun bindEditReminderUseCase(useCaseImpl: EditReminderUseCaseImpl): EditReminderUseCase
}