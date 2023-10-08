package com.alexberghii.domain.api.reminders.models


data class ReminderModel(
    val id: Int,
    val title: String,
    val time: String,
    val isEnabled: Boolean
)