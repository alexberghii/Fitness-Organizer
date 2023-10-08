package com.alexberghii.core

import android.os.Bundle
import android.view.View
import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment


abstract class BaseFragment(@LayoutRes layoutResId: Int) : Fragment(layoutResId) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        onInitView(savedInstanceState)
    }

    protected open fun onInitView(savedInstanceState: Bundle?) {}
}