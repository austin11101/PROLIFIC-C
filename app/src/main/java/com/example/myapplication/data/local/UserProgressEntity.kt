package com.example.myapplication.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user_progress")
data class UserProgressEntity(
    @PrimaryKey val lessonId: String,
    val completionPercentage: Int,
    val highestWpmAchieved: Int,
    val lastReadTimestamp: Long = System.currentTimeMillis()
)

@Entity(tableName = "user_streak")
data class UserStreakEntity(
    @PrimaryKey val id: Int = 1,
    val streakDays: Int = 3,
    val lastActiveDate: String
)
