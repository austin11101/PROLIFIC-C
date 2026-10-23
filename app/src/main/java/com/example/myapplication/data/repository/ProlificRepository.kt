package com.example.myapplication.data.repository

import com.example.myapplication.data.model.Category
import com.example.myapplication.data.model.DifficultyLevel
import com.example.myapplication.data.model.Language
import com.example.myapplication.data.model.Lesson

object ProlificRepository {

    val categories = listOf(
        Category(
            id = "heritage",
            name = "South African Heritage",
            description = "Explore rich history, landmarks, and culture across South Africa.",
            iconEmoji = "🇿🇦",
            lessonCount = 3
        ),
        Category(
            id = "nature",
            name = "Animals & Nature",
            description = "Discover the Big Five and wildlife conservation in national parks.",
            iconEmoji = "🦁",
            lessonCount = 2
        ),
        Category(
            id = "science",
            name = "Science & Discovery",
            description = "Fascinating facts about astronomy, innovation, and technology.",
            iconEmoji = "🚀",
            lessonCount = 2
        ),
        Category(
            id = "psychology",
            name = "Mind & Growth",
            description = "Practical insights on focus, reading confidence, and personal growth.",
            iconEmoji = "🧠",
            lessonCount = 2
        )
    )

    private val lessons = listOf(
        // English Lessons
        Lesson(
            id = "en_heritage_1",
            title = "The Spirit of Ubuntu",
            categoryId = "heritage",
            language = Language.ENGLISH,
            content = "Ubuntu is an ancient African philosophy based on human interconnectedness. It expresses the profound truth that a person is a person through other persons. When we practice Ubuntu, we foster community, empathy, and shared respect across all cultures in South Africa.",
            isGuestEligible = true,
            difficulty = DifficultyLevel.EASY
        ),
        Lesson(
            id = "en_nature_1",
            title = "Kruger National Park Wildlife",
            categoryId = "nature",
            language = Language.ENGLISH,
            content = "The Kruger National Park is one of Africa's largest game reserves. High density of wild animals includes the Big Five: lions, leopards, rhinos, elephants, and buffalos. Rangers and conservationists work daily to protect these majestic creatures for future generations.",
            isGuestEligible = true,
            difficulty = DifficultyLevel.MEDIUM
        ),
        Lesson(
            id = "en_science_1",
            title = "The Square Kilometre Array",
            categoryId = "science",
            language = Language.ENGLISH,
            content = "South Africa hosts part of the Square Kilometre Array, the world's most powerful radio telescope. Located in the quiet Karoo region, SKA allows scientists to study distant galaxies, cosmic origins, and the secrets of the universe with incredible precision.",
            isGuestEligible = false,
            difficulty = DifficultyLevel.HARD
        ),

        // isiZulu Lessons
        Lesson(
            id = "zu_heritage_1",
            title = "Umlando we-Ubuntu",
            categoryId = "heritage",
            language = Language.ISIZULU,
            content = "Ubuntu wumcabango ojulile wase-Afrika obophezela abantu bonke ndawonye. Sisho ukuthi umuntu ngumuntu ngabantu. Uma siphila ngobuntu, sakha ukuthula, inhlonipho, nokusebenzisana emphakathini wethu waseNingizimu Afrika.",
            isGuestEligible = true,
            difficulty = DifficultyLevel.EASY
        ),
        Lesson(
            id = "zu_nature_1",
            title = "Izilwane eKruger Park",
            categoryId = "nature",
            language = Language.ISIZULU,
            content = "Iphaki iKruger ingenye yezindawo ezinkulu zokugcina izilwane e-Afrika. Izilwane ezaziwayo pambili zibandakanya ingonyama, indlovu, ubhejane, ingwe, nenyathi. Abaqaphi basebenza tshengisa ukuvikela lezi zilwane ezibalulekile.",
            isGuestEligible = true,
            difficulty = DifficultyLevel.MEDIUM
        ),

        // Sepedi Lessons
        Lesson(
            id = "nso_heritage_1",
            title = "Moya wa Botho",
            categoryId = "heritage",
            language = Language.SEPEDI,
            content = "Botho ke filosofi ya kgale ya Afrika e meletšego go kgokaganyo ya batho ka moka. E hlaloša gore motho ke motho ka batho ba bangwe. Ge re phela ka botho, re aga khutšo, tlhompho le tsebanagano nageng ya rena ya Afrika Borwa.",
            isGuestEligible = true,
            difficulty = DifficultyLevel.EASY
        ),
        Lesson(
            id = "nso_psychology_1",
            title = "Tswelopele ya go Bala",
            categoryId = "psychology",
            language = Language.SEPEDI,
            content = "Go bala ka lebelo le go kwešiša go fa motho tshepho le tsebo. Ge o itlwaetša go bala ka tšatši le tšatši, bokgoni bja gago bja go kwišiša ditaba bo a goda. Tswela pele go ithuta ka lethabo le mafolofolo.",
            isGuestEligible = true,
            difficulty = DifficultyLevel.EASY
        )
    )

    fun getLessonsForLanguageAndCategory(language: Language, categoryId: String): List<Lesson> {
        return lessons.filter { it.language == language && it.categoryId == categoryId }
    }

    fun getFeaturedLessonsForLanguage(language: Language): List<Lesson> {
        return lessons.filter { it.language == language }
    }

    fun getLessonById(lessonId: String): Lesson? {
        return lessons.firstOrNull { it.id == lessonId }
    }

    fun getCategoryById(categoryId: String): Category? {
        return categories.firstOrNull { it.id == categoryId }
    }
}
