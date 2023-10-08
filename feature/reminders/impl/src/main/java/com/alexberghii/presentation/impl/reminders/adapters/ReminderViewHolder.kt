package com.alexberghii.presentation.impl.reminders.adapters

import android.view.View
import androidx.annotation.LayoutRes
import com.alexberghii.core.viewComponents.adapter.BaseViewHolder
import com.alexberghii.domain.api.reminders.models.ReminderModel
import com.alexberghii.feature.reminders.impl.R
import com.alexberghii.feature.reminders.impl.databinding.ItemReminderBinding


class ReminderViewHolder(
    itemView: View
) : BaseViewHolder<ReminderModel>(itemView) {

    private val viewBinding = ItemReminderBinding.bind(itemView)

    override fun bind(item: ReminderModel) {
        viewBinding.textViewTitle.text = item.title
        viewBinding.textViewTime.text = item.time
        viewBinding.switchEnable.isChecked = item.isEnabled
    }

    companion object {
        @LayoutRes
        val LAYOUT = R.layout.item_reminder
    }
}