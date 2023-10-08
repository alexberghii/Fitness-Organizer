package com.alexberghii.domain.impl.reminders.di

import com.alexberghii.domain.api.reminders.usecases.GetRemindersUseCase
import com.alexberghii.domain.impl.reminders.usecases.GetRemindersUseCaseImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent


@Module
@InstallIn(ViewModelComponent::class)
abstract class RemindersModule {

    @Binds
    abstract fun bindGetRemindersUseCase(useCaseImpl: GetRemindersUseCaseImpl): GetRemindersUseCase
}