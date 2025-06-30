package ru.fefu.fefufit.data

import androidx.room.TypeConverter

class Converters {
    @TypeConverter
    fun toActivityType(value: String): ActivityType = ActivityType.valueOf(value)

    @TypeConverter
    fun fromActivityType(value: ActivityType): String = value.name
} 