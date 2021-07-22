package com.example.harajtask.utils

import android.annotation.SuppressLint
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*


@SuppressLint("SimpleDateFormat")
fun convertLongToTimeStamp(seconds: Long): String {
    val formatter = SimpleDateFormat("yyyy/MM/dd hh:mm aa")
    return formatter.format(Date(seconds * 1000L))
}

@SuppressLint("SimpleDateFormat")
fun convertLongToDate(seconds: Long): Date? {
    val formatter = SimpleDateFormat("yyyy-MM-dd")
    val stringDate = formatter.format(Date(seconds * 1000L))
    return formatter.parse(stringDate)
}

fun Date.getTimeAgo(): String {
    val calendar = Calendar.getInstance()
    calendar.time = this

    val year = calendar.get(Calendar.YEAR)
    val month = calendar.get(Calendar.MONTH)
    val day = calendar.get(Calendar.DAY_OF_MONTH)
    val hour = calendar.get(Calendar.HOUR_OF_DAY)
    val minute = calendar.get(Calendar.MINUTE)

    val currentCalendar = Calendar.getInstance()

    val currentYear = currentCalendar.get(Calendar.YEAR)
    val currentMonth = currentCalendar.get(Calendar.MONTH)
    val currentDay = currentCalendar.get(Calendar.DAY_OF_MONTH)
    val currentHour = currentCalendar.get(Calendar.HOUR_OF_DAY)
    val currentMinute = currentCalendar.get(Calendar.MINUTE)

    return if (year < currentYear ) {
        val interval = currentYear - year
        if (interval == 1) "Since $interval years" else " Since $interval years"
    } else if (month < currentMonth) {
        val interval = currentMonth - month
        if (interval == 1) "Since $interval month" else "Since $interval months"
    } else  if (day < currentDay) {
        val interval = currentDay - day
        if (interval == 1) "Since $interval day" else "Since $interval days"
    } else if (hour < currentHour) {
        val interval = currentHour - hour
        if (interval == 1) "Since $interval hour" else "Since $interval hours"
    } else if (minute < currentMinute) {
        val interval = currentMinute - minute
        if (interval == 1) "Since $interval minute" else "Since $interval minutes"
    } else {
        "a moment ago"
    }
}
