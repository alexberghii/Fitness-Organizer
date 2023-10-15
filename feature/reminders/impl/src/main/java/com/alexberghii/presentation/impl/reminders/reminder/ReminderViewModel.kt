package com.alexberghii.presentation.impl.reminders.reminder

import androidx.lifecycle.viewModelScope
import androidx.navigation.NavController
import com.alexberghii.core.BaseViewModel
import com.alexberghii.core.navigation.NavEvent
import com.alexberghii.domain.api.reminders.models.ReminderModel
import com.alexberghii.domain.api.reminders.usecases.AddReminderUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class ReminderViewModel @Inject constructor(
    private val addReminderUseCase: AddReminderUseCase
) : BaseViewModel() {

    fun saveReminder(title: String, time: String, isEnabled: Boolean) {
        viewModelScope.launch {
            addReminderUseCase.invoke(ReminderModel(title, time, isEnabled))
            navEvent.stateValue = NavEvent.Back
        }
    }
}