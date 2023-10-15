package com.alexberghii.domain.api.reminders.models


data class ReminderModel(
    val id: Int,
    val title: String,
    val time: String,
    val isEnabled: Boolean
) {
    
    constructor(title: String, time: String, isEnabled: Boolean): this(0, title, time, isEnabled)
}