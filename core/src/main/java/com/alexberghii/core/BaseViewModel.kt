package com.alexberghii.core

import androidx.lifecycle.ViewModel
import com.alexberghii.core.navigation.NavEvent
import kotlinx.coroutines.flow.MutableStateFlow


abstract class BaseViewModel : ViewModel() {

    val navEvent: VMStateFlow<NavEvent> = createVMStateFlow(NavEvent.None)

    protected fun navigate(navEvent: NavEvent) {
        this.navEvent.stateValue = navEvent
        this.navEvent.stateValue = NavEvent.None
    }

    // TODO swap with explicit backing fields when they are released
    private class VMStateFlowImpl<T>(
        value: T,
        val wrappedStateFlow: MutableStateFlow<T> = MutableStateFlow(value)
    ) : VMStateFlow<T>(wrappedStateFlow)

    protected fun <T> createVMStateFlow(value: T): VMStateFlow<T> = VMStateFlowImpl(value)

    protected var <T> VMStateFlow<T>.stateValue: T
        get() = this.value
        set(value) {
            when (this){
                is VMStateFlowImpl -> this.wrappedStateFlow.value = value
            }
        }
}