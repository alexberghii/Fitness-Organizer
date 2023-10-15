package com.alexberghii.core.navigation

import androidx.navigation.NavDirections


sealed class NavEvent {

    data class To(val directions: NavDirections) : NavEvent()
    object Back : NavEvent()
    object None : NavEvent()
}