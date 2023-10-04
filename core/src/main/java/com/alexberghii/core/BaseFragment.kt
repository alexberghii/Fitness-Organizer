package com.alexberghii.core

import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment


abstract class BaseFragment(@LayoutRes layoutResId: Int) : Fragment(layoutResId) {
}