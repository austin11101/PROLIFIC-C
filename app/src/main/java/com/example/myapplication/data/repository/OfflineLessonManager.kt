package com.example.myapplication.data.repository

import com.example.myapplication.data.model.Lesson

object OfflineLessonManager {
    private val downloadedLessonIds = mutableSetOf<String>()

    fun isLessonDownloaded(lessonId: String): Boolean {
        return downloadedLessonIds.contains(lessonId)
    }

    fun downloadLesson(lesson: Lesson) {
        downloadedLessonIds.add(lesson.id)
    }

    fun removeLesson(lessonId: String) {
        downloadedLessonIds.remove(lessonId)
    }

    fun getDownloadedCount(): Int {
        return downloadedLessonIds.size
    }
}
