package com.max.cathay_pacific.first

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.max.cathay_pacific.databinding.ItemCalendarBinding

class CalendarAdapter(
    itemDiffCallback: DiffUtil.ItemCallback<CalendarItem> = CalendarItemDiffUtilCallback()
) : ListAdapter<CalendarItem, CalendarViewHolder>(itemDiffCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CalendarViewHolder {
        val binding = ItemCalendarBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return CalendarViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CalendarViewHolder, position: Int) {
        holder.onBind(getItem(position))
    }
}