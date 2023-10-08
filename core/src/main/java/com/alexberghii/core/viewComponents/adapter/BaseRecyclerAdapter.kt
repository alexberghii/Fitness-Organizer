package com.alexberghii.core.viewComponents.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.recyclerview.widget.RecyclerView


abstract class BaseRecyclerAdapter<T : Any> (
    itemList: List<T> = listOf()
) : RecyclerView.Adapter<BaseViewHolder<T>>() {

    private val items: MutableList<T> = mutableListOf()

    init {
        this.items.addAll(itemList)
    }

    @LayoutRes
    protected abstract fun getHolderLayout(viewType: Int): Int

    protected abstract fun getHolder(view: View): BaseViewHolder<T>

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<T> =
        getHolder(LayoutInflater.from(parent.context).inflate(getHolderLayout(viewType), parent, false))

    @SuppressLint("NotifyDataSetChanged")
    fun update(items: List<T>) {
        this.items.clear()
        this.items.addAll(items)
        notifyDataSetChanged()
    }

    fun add(item: T) {
        this.items.add(0, item)
        notifyItemRangeInserted(0, 1)
    }

    fun addLast(item: T) {
        this.items.add(item)
        notifyItemRangeInserted(this.items.size - 1, 1)
    }

    fun removeItem(position: Int) {
        items.removeAt(position)
        notifyItemRemoved(position)
    }

    @SuppressLint("NotifyDataSetChanged")
    fun clearAll() {
        this.items.clear()
        notifyDataSetChanged()
    }

    fun getItems(): List<T> = items

    fun getItem(position: Int) = items[position]

    fun remove(element: T) {
        val index = items.indexOf(element)
        if (index < 0 || index > items.size - 1) return
        items.removeAt(index)
        notifyItemRemoved(index)
    }

    fun replace(old: T, new: T) {
        val index = items.indexOf(old)
        if (index < 0 || index > items.size - 1) return
        items[index] = new
        notifyItemChanged(index, new)
    }

    override fun onBindViewHolder(holder: BaseViewHolder<T>, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount() = items.size
}