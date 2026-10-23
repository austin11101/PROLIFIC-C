package com.example.myapplication.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(
    entities = [LessonEntity::class, UserProgressEntity::class, UserStreakEntity::class],
    version = 1,
    exportSchema = false
)
abstract class ProlificDatabase : RoomDatabase() {

    abstract fun lessonDao(): LessonDao
    abstract fun userProgressDao(): UserProgressDao

    companion object {
        @Volatile
        private var INSTANCE: ProlificDatabase? = null

        fun getDatabase(context: Context): ProlificDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    ProlificDatabase::class.java,
                    "prolific_database"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}
