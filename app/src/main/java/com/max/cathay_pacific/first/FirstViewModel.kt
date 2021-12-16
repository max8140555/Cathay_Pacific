package com.max.cathay_pacific.first

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.max.cathay_pacific.util.CalendarUtil.getTaiwanTime
import java.util.Calendar.*

class FirstViewModel : ViewModel() {

    companion object {
        private const val TODAY_POSITION = 1
    }

    private val _items: MutableLiveData<List<CalendarItem>> = MutableLiveData(createCalendarItem())
    val items: LiveData<List<CalendarItem>> get() = _items

    private fun createCalendarItem(): List<CalendarItem> {
        val currentCalendar = getTaiwanTime()
        val weeks =
            listOf("Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday")
        val items = mutableListOf<CalendarItem>()

        for (i in 1..20) {
            if (i != TODAY_POSITION) {
                currentCalendar.add(DAY_OF_MONTH, 1)
            }

            val weekIndex = currentCalendar.get(DAY_OF_WEEK) - 1
            val date = "${currentCalendar.get(MONDAY) + 1}/${currentCalendar.get(DAY_OF_MONTH)}"
            val calendarText = "$date (${weeks[weekIndex]})"
            val item = CalendarItem(i, calendarText)

            items.add(item)
        }

        return items.toList()
    }
}