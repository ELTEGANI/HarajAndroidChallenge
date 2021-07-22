package com.example.harajtask.utils

import android.annotation.SuppressLint
import java.text.SimpleDateFormat
import java.util.*


@SuppressLint("SimpleDateFormat")
fun convertLongToDate(seconds: Long): String {
    val formatter = SimpleDateFormat("yyyy/MM/dd hh:mm aa")
    return formatter.format(Date(seconds * 1000L))
}