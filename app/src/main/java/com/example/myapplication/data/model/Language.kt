package com.example.myapplication.data.model

enum class Language(
    val code: String,
    val displayName: String,
    val nativeName: String,
    val flagEmoji: String
) {
    ENGLISH("en", "English", "English", "🇿🇦"),
    ISIZULU("zu", "isiZulu", "isiZulu", "🇿🇦"),
    SEPEDI("nso", "Sepedi", "Sesotho sa Leboa", "🇿🇦");

    companion object {
        fun fromCode(code: String): Language {
            return entries.firstOrNull { it.code == code } ?: ENGLISH
        }
    }
}
