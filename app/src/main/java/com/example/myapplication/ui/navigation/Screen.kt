package com.example.myapplication.ui.navigation

sealed class Screen(val route: String) {
    object Welcome : Screen("welcome")
    object Login : Screen("login")
    object Signup : Screen("signup")
    object LanguageSelection : Screen("language_selection")
    object Home : Screen("home/{langCode}/{username}") {
        fun createRoute(langCode: String, username: String) = "home/$langCode/$username"
    }
    object TopicDetail : Screen("topic/{langCode}/{categoryId}") {
        fun createRoute(langCode: String, categoryId: String) = "topic/$langCode/$categoryId"
    }
    object GuidedReadingPlayer : Screen("reader/{lessonId}/{wpm}") {
        fun createRoute(lessonId: String, wpm: Int) = "reader/$lessonId/$wpm"
    }
}
