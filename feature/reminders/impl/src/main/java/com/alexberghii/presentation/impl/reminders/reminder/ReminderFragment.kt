package com.alexberghii.presentation.impl.reminders.reminder

import android.os.Bundle
import androidx.fragment.app.viewModels
import com.alexberghii.core.BaseFragment
import com.alexberghii.core.viewComponents.viewBinding
import com.alexberghii.feature.reminders.impl.R
import com.alexberghii.feature.reminders.impl.databinding.FragmentReminderBinding
import com.google.android.material.timepicker.MaterialTimePicker
import com.google.android.material.timepicker.TimeFormat
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class ReminderFragment : BaseFragment(R.layout.fragment_reminder) {

    private val viewBinding by viewBinding(FragmentReminderBinding::bind)

    private val viewModel: ReminderViewModel by viewModels()

    override fun onInitView(savedInstanceState: Bundle?) {
        super.onInitView(savedInstanceState)

        with (viewBinding) {
            tvTime.setOnClickListener { showTimePicker() }
            btnSave.setOnClickListener { viewModel.saveReminder(etTitle.text.toString(), tvTime.text.toString(), switchEnable.isChecked) }
        }
    }

    private fun showTimePicker() {
        val picker = MaterialTimePicker.Builder()
            .setTimeFormat(TimeFormat.CLOCK_24H)
            .build()
        picker.addOnPositiveButtonClickListener { viewBinding.tvTime.text = "${picker.hour}:${picker.minute}" }
        picker.show(childFragmentManager, "TIME_PICKER")
    }
}