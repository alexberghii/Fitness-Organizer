package com.alexberghii.core

import android.os.Bundle
import android.view.View
import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.alexberghii.core.navigation.NavEvent


abstract class BaseFragment(@LayoutRes layoutResId: Int) : Fragment(layoutResId) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        onInitView(savedInstanceState)
    }

    protected open fun onInitView(savedInstanceState: Bundle?) {}

    protected fun navigate(navEvent: NavEvent) {
        when(navEvent) {
            is NavEvent.To -> findNavController().navigate(navEvent.directions)
            is NavEvent.Back -> findNavController().popBackStack()
            else -> {}
        }
    }
}