package com.alexberghii.presentation.impl.reminders.adapters

import android.view.View
import com.alexberghii.core.viewComponents.adapter.BaseRecyclerAdapter
import com.alexberghii.core.viewComponents.adapter.BaseViewHolder
import com.alexberghii.domain.api.reminders.models.ReminderModel


class RemindersAdapter : BaseRecyclerAdapter<com.alexberghii.domain.api.reminders.models.ReminderModel>() {

    override fun getHolderLayout(viewType: Int): Int = ReminderViewHolder.LAYOUT

    override fun getHolder(view: View): BaseViewHolder<com.alexberghii.domain.api.reminders.models.ReminderModel> = ReminderViewHolder(view)

}