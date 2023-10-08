package com.alexberghii.database.dao

import androidx.room.Dao
import androidx.room.Query
import com.alexberghii.database.entity.ReminderEntity


@Dao
abstract class ReminderDao : BaseDao<ReminderEntity> {

    @Query("select * from reminder")
    abstract suspend fun getAll(): List<ReminderEntity>

    @Query("select * from reminder where id == :id")
    abstract suspend fun getById(id: Int): ReminderEntity

    @Query("delete from reminder")
    abstract fun deleteAll()
}