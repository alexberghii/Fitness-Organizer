package com.alexberghii.presentation.impl.reminders

import androidx.lifecycle.viewModelScope
import com.alexberghii.core.BaseViewModel
import com.alexberghii.core.VMStateFlow
import com.alexberghii.domain.api.reminders.models.ReminderModel
import com.alexberghii.domain.api.reminders.usecases.GetRemindersUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class RemindersViewModel @Inject constructor(
    private val getRemindersUseCase: GetRemindersUseCase
) : BaseViewModel() {

    val reminders: VMStateFlow<List<ReminderModel>> = createVMStateFlow(emptyList())

    fun onViewsLoaded() {
        getReminders()
    }

    private fun getReminders() {
        viewModelScope.launch(Dispatchers.IO) {
            reminders.stateValue = getRemindersUseCase.invoke()
        }
    }
}