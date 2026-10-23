package com.example.myapplication.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface LessonDao {
    @Query("SELECT * FROM downloaded_lessons WHERE languageCode = :langCode")
    suspend fun getDownloadedLessonsByLanguage(langCode: String): List<LessonEntity>

    @Query("SELECT * FROM downloaded_lessons WHERE id = :lessonId")
    suspend fun getLessonById(lessonId: String): LessonEntity?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertLesson(lesson: LessonEntity)

    @Query("DELETE FROM downloaded_lessons WHERE id = :lessonId")
    suspend fun deleteLesson(lessonId: String)
}
