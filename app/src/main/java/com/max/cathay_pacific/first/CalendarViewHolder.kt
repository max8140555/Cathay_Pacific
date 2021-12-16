package com.max.cathay_pacific.first

import androidx.recyclerview.widget.RecyclerView
import com.max.cathay_pacific.R
import com.max.cathay_pacific.databinding.ItemCalendarBinding

class CalendarViewHolder(
    private val binding: ItemCalendarBinding,
) : RecyclerView.ViewHolder(binding.root) {

    fun onBind(item: CalendarItem) {
        binding.textViewPosition.text =
            itemView.context.getString(R.string.item_position, item.position)
        binding.textViewCalendar.text = item.calendarText
    }
}