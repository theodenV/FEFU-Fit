package ru.fefu.fefufit.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters

@Database(entities = [ActivityEntity::class], version = 1)
@TypeConverters(Converters::class)
abstract class AppDatabase : RoomDatabase() {

    companion object {
        @Volatile private var databaseInstance: AppDatabase? = null

        fun getInstance(context: Context): AppDatabase =
            databaseInstance ?: synchronized(this) {
                databaseInstance ?: Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java, "activity.db"
                ).build().also { databaseInstance = it }
            }
    }

    abstract fun activityDao(): ActivityDao
} 