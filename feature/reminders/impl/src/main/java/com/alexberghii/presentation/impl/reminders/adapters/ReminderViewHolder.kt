package com.alexberghii.presentation.impl.reminders.adapters

import android.view.View
import android.widget.PopupMenu
import androidx.annotation.LayoutRes
import com.alexberghii.core.viewComponents.adapter.BaseViewHolder
import com.alexberghii.domain.api.reminders.models.ReminderModel
import com.alexberghii.feature.reminders.impl.R
import com.alexberghii.feature.reminders.impl.databinding.ItemReminderBinding


class ReminderViewHolder(
    private val onStateChanged: (ReminderModel, Boolean) -> Unit,
    private val onEditClick: (ReminderModel) -> Unit,
    private val onDeleteClick: (ReminderModel) -> Unit,
    itemView: View
) : BaseViewHolder<ReminderModel>(itemView) {

    private val viewBinding = ItemReminderBinding.bind(itemView)

    override fun bind(item: ReminderModel) {
        viewBinding.textViewTitle.text = item.title
        viewBinding.textViewTime.text = item.time
        viewBinding.switchEnable.isChecked = item.isEnabled
        viewBinding.switchEnable.setOnCheckedChangeListener { _, isChecked -> onStateChanged(item, isChecked) }
        itemView.setOnLongClickListener {
            PopupMenu(itemView.context, itemView).apply {
                inflate(R.menu.reminder_menu)
                setOnMenuItemClickListener { menuItem ->
                    when (menuItem.itemId) {
                        R.id.action_edit -> {
                            onEditClick(item)
                            true
                        }
                        R.id.action_delete -> {
                            onDeleteClick(item)
                            true
                        }
                        else -> false
                    }
                }
                show()
            }
            true
        }
    }

    companion object {
        @LayoutRes
        val LAYOUT = R.layout.item_reminder
    }
}