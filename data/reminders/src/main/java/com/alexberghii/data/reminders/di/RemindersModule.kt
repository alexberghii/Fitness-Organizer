package com.alexberghii.data.reminders.di

import com.alexberghii.data.reminders.repositories.RemindersRepositoryImpl
import com.alexberghii.domain.api.reminders.repositories.RemindersRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent


@Module
@InstallIn(ViewModelComponent::class)
abstract class RemindersModule {

    @Binds
    abstract fun bindRemindersRepository(repositoryImpl: RemindersRepositoryImpl): RemindersRepository
}