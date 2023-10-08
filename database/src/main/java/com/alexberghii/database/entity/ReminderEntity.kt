package com.alexberghii.database.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "reminder")
data class ReminderEntity(
    @PrimaryKey
    val id: Int,
    val title: String,
    val time: String,
    @ColumnInfo(name = "is_enabled")
    val isEnabled: Boolean
)