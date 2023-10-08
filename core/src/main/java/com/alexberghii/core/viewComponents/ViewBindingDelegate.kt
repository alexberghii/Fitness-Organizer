package com.alexberghii.core.viewComponents

import android.os.Handler
import android.os.Looper
import android.view.View
import androidx.annotation.MainThread
import androidx.fragment.app.Fragment
import androidx.lifecycle.DefaultLifecycleObserver
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleOwner
import androidx.viewbinding.ViewBinding
import kotlin.properties.ReadOnlyProperty
import kotlin.reflect.KProperty


fun <T : ViewBinding> Fragment.viewBinding(
    viewBindingFactory: (View) -> T
): ReadOnlyProperty<Fragment, T> = fragmentViewBinding(viewBindingFactory)

private fun <T : ViewBinding> Fragment.fragmentViewBinding(
    viewBindingFactory: (View) -> T,
) = FragmentViewBindingDelegate(
    fragment = this,
    viewBindingFactory = viewBindingFactory
)

private class FragmentViewBindingDelegate<T : ViewBinding>(
    val fragment: Fragment,
    val viewBindingFactory: (View) -> T,
) : ReadOnlyProperty<Fragment, T> {
    private var binding: T? = null
    private val mainHandler = Handler(Looper.getMainLooper())

    @MainThread
    override fun getValue(thisRef: Fragment, property: KProperty<*>): T {
        binding?.takeIf { cachedBinding -> cachedBinding.root == thisRef.view }
            ?.let { cachedBinding -> return cachedBinding }
        val binding = viewBindingFactory(thisRef.requireView())
        this.binding = binding
        clearViewBindingOnDestroy(fragment.viewLifecycleOwner.lifecycle)
        return binding
    }

    @MainThread
    private fun clearViewBindingOnDestroy(lifecycle: Lifecycle) {
        lifecycle.addObserver(
            object : DefaultLifecycleObserver {
                override fun onDestroy(owner: LifecycleOwner) {
                    lifecycle.removeObserver(this)
                    mainHandler.post { binding = null }
                }
            }
        )
    }
}