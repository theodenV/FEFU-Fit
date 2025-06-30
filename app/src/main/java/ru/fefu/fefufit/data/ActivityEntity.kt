package ru.fefu.fefufit.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "activity")
data class ActivityEntity(
    @PrimaryKey(autoGenerate = true) val activityId: Int = 0,
    @ColumnInfo(name = "type") val activityType: ActivityType,
    @ColumnInfo(name = "start_time") val startTime: Long,
    @ColumnInfo(name = "end_time") val endTime: Long,
    @ColumnInfo(name = "coordinates") val locationData: String // JSON строка
) 