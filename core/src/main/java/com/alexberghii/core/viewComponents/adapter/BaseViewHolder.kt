package com.alexberghii.core.viewComponents.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView


abstract class BaseViewHolder<T>(containerView: View) : RecyclerView.ViewHolder(containerView) {
    open fun bind(item: T) {}
}