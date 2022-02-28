package com.example.kotlin_demo.room

import androidx.room.TypeConverter
import java.util.*

class Converters {
    @TypeConverter
    fun DateToLong(date: Date): Long {
        return date.time
    }

    @TypeConverter
    fun LongToDate(long: Long): Date {
        return Date(long)
    }
}