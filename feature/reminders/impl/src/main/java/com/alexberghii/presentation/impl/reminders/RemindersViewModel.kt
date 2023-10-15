package com.alexberghii.presentation.impl.reminders

import androidx.lifecycle.viewModelScope
import com.alexberghii.core.BaseViewModel
import com.alexberghii.core.VMStateFlow
import com.alexberghii.core.navigation.NavEvent
import com.alexberghii.domain.api.reminders.models.ReminderModel
import com.alexberghii.domain.api.reminders.usecases.AddReminderUseCase
import com.alexberghii.domain.api.reminders.usecases.DeleteReminderUseCase
import com.alexberghii.domain.api.reminders.usecases.GetRemindersUseCase
import com.alexberghii.domain.api.reminders.usecases.UpdateReminderStateUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class RemindersViewModel @Inject constructor(
    private val getRemindersUseCase: GetRemindersUseCase,
    private val deleteReminderUseCase: DeleteReminderUseCase,
    private val updateReminderStateUseCase: UpdateReminderStateUseCase,
) : BaseViewModel() {

    val reminders: VMStateFlow<List<ReminderModel>> = createVMStateFlow(emptyList())

    fun onViewsLoaded() {
        getReminders()
    }

    fun editReminder(reminder: ReminderModel) {}

    fun deleteReminder(reminder: ReminderModel) {
        viewModelScope.launch {
            deleteReminderUseCase.invoke(reminder)
            getReminders()
        }
    }

    fun onReminderStateChange(reminder: ReminderModel, isEnabled: Boolean) {
        viewModelScope.launch {
            updateReminderStateUseCase.invoke(reminder, isEnabled)
        }
    }

    fun addReminder() {
        navigate(NavEvent.To(RemindersFragmentDirections.actionRemindersFragmentToReminderFragment()))
    }

    private fun getReminders() {
        viewModelScope.launch {
            reminders.stateValue = getRemindersUseCase.invoke()
        }
    }
}