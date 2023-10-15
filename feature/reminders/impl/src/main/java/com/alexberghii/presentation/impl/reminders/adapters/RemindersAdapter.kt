package com.alexberghii.presentation.impl.reminders.adapters

import android.view.View
import com.alexberghii.core.viewComponents.adapter.BaseRecyclerAdapter
import com.alexberghii.core.viewComponents.adapter.BaseViewHolder
import com.alexberghii.domain.api.reminders.models.ReminderModel


class RemindersAdapter(
    private val onStateChanged: (ReminderModel, Boolean) -> Unit,
    private val onEditClick: (ReminderModel) -> Unit,
    private val onDeleteClick: (ReminderModel) -> Unit,
) : BaseRecyclerAdapter<ReminderModel>() {

    override fun getHolderLayout(viewType: Int): Int = ReminderViewHolder.LAYOUT

    override fun getHolder(view: View): BaseViewHolder<ReminderModel> =
        ReminderViewHolder(onStateChanged, onEditClick, onDeleteClick, view)
}