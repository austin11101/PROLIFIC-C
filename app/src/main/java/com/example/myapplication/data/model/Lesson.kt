package com.example.myapplication.data.model

enum class DifficultyLevel(val label: String, val targetWpm: Int) {
    EASY("Easy", 100),
    MEDIUM("Medium", 150),
    HARD("Hard", 200)
}

data class Lesson(
    val id: String,
    val title: String,
    val categoryId: String,
    val language: Language,
    val content: String,
    val isGuestEligible: Boolean = true,
    val difficulty: DifficultyLevel = DifficultyLevel.EASY
) {
    val words: List<String>
        get() = content.split("\\s+".toRegex()).filter { it.isNotBlank() }

    val wordCount: Int
        get() = words.size
}
