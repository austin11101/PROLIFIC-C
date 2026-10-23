package com.example.myapplication.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "downloaded_lessons")
data class LessonEntity(
    @PrimaryKey val id: String,
    val title: String,
    val categoryId: String,
    val languageCode: String,
    val content: String,
    val targetWpm: Int,
    val isGuestEligible: Boolean,
    val downloadedTimestamp: Long = System.currentTimeMillis()
)
