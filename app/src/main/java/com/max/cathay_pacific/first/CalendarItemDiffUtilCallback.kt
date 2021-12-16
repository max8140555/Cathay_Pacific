package com.max.cathay_pacific.first

import androidx.recyclerview.widget.DiffUtil

class CalendarItemDiffUtilCallback : DiffUtil.ItemCallback<CalendarItem>() {

    override fun areItemsTheSame(
        oldItem: CalendarItem,
        newItem: CalendarItem
    ): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(
        oldItem: CalendarItem,
        newItem: CalendarItem
    ): Boolean {
        return oldItem == newItem
    }
}