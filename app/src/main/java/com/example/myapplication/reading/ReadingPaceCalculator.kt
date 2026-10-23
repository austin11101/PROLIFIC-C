package com.example.myapplication.reading

object ReadingPaceCalculator {

    fun calculateBaseDelayMillis(wpm: Int): Long {
        if (wpm <= 0) return 600L
        return (60_000L / wpm)
    }

    fun calculateWordDurationMillis(word: String, targetWpm: Int): Long {
        val baseDelay = calculateBaseDelayMillis(targetWpm)
        val cleanWord = word.trim()

        val punctuationBonus = when {
            cleanWord.endsWith(".") || cleanWord.endsWith("?") || cleanWord.endsWith("!") -> 350L
            cleanWord.endsWith(",") || cleanWord.endsWith(";") || cleanWord.endsWith(":") -> 180L
            else -> 0L
        }

        return baseDelay + punctuationBonus
    }
}
