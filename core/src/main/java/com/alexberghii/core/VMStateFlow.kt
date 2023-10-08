package com.alexberghii.core

import kotlinx.coroutines.flow.StateFlow


sealed class VMStateFlow<T>(stateFlow: StateFlow<T>) : StateFlow<T> by stateFlow