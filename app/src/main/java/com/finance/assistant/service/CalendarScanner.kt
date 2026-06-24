package com.finance.assistant.service

import android.content.ContentResolver
import android.content.ContentUris
import android.provider.CalendarContract
import com.finance.assistant.domain.model.CalendarEvent
import java.time.Instant
import java.time.LocalDateTime
import java.time.ZoneId
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class CalendarScanner @Inject constructor(
    private val contentResolver: ContentResolver,
) {

    fun scanUpcomingEvents(daysAhead: Int = 30): List<CalendarEvent> {
        val events = mutableListOf<CalendarEvent>()
        val now = System.currentTimeMillis()
        val endTime = now + daysAhead * 24L * 60 * 60 * 1000

        val projection = arrayOf(
            CalendarContract.Events._ID,
            CalendarContract.Events.TITLE,
            CalendarContract.Events.DESCRIPTION,
            CalendarContract.Events.DTSTART,
            CalendarContract.Events.DTEND,
            CalendarContract.Events.EVENT_LOCATION,
            CalendarContract.Events.ALL_DAY,
            CalendarContract.Events.CALENDAR_DISPLAY_NAME,
        )

        val selection = "${CalendarContract.Events.DTSTART} >= ? AND ${CalendarContract.Events.DTSTART} <= ?"
        val selectionArgs = arrayOf(now.toString(), endTime.toString())

        val cursor = contentResolver.query(
            CalendarContract.Events.CONTENT_URI,
            projection,
            selection,
            selectionArgs,
            "${CalendarContract.Events.DTSTART} ASC",
        )

        cursor?.use {
            while (it.moveToNext()) {
                val event = CalendarEvent(
                    id = it.getLong(0),
                    title = it.getString(1) ?: "",
                    description = it.getString(2) ?: "",
                    startTime = LocalDateTime.ofInstant(
                        Instant.ofEpochMilli(it.getLong(3)),
                        ZoneId.systemDefault(),
                    ),
                    endTime = LocalDateTime.ofInstant(
                        Instant.ofEpochMilli(it.getLong(4)),
                        ZoneId.systemDefault(),
                    ),
                    location = it.getString(5),
                    isAllDay = it.getInt(6) == 1,
                    calendarName = it.getString(7),
                )
                events.add(event)
            }
        }
        return events
    }

    companion object {
        private const val TAG = "CalendarScanner"
    }
}
