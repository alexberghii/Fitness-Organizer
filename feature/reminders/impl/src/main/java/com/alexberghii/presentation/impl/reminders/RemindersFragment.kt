package com.alexberghii.presentation.impl.reminders

import android.os.Bundle
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.alexberghii.core.BaseFragment
import com.alexberghii.core.utils.observeWithLifecycle
import com.alexberghii.core.viewComponents.viewBinding
import com.alexberghii.domain.api.reminders.models.ReminderModel
import com.alexberghii.feature.reminders.impl.R
import com.alexberghii.feature.reminders.impl.databinding.FragmentRemindersBinding
import com.alexberghii.presentation.impl.reminders.adapters.RemindersAdapter
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class RemindersFragment : BaseFragment(R.layout.fragment_reminders) {

    private val viewBinding by viewBinding(FragmentRemindersBinding::bind)

    private val viewModel: RemindersViewModel by viewModels()

    private val remindersAdapter: RemindersAdapter by lazy {
        RemindersAdapter(viewModel::onReminderStateChange, viewModel::editReminder, viewModel::deleteReminder)
    }

    override fun onInitView(savedInstanceState: Bundle?) {
        super.onInitView(savedInstanceState)

        viewBinding.rvReminders.adapter = remindersAdapter

        viewBinding.fabAddReminder.setOnClickListener { findNavController().navigate(com.alexberghii.navigation.R.id.action_remindersFragment_to_reminderFragment) }
        viewModel.onViewsLoaded()
        observeData()
    }

    private fun observeData() {
        viewModel.reminders.observeWithLifecycle(this) { reminders ->
            remindersAdapter.update(reminders)
        }
    }
}