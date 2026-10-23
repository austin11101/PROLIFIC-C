package com.example.myapplication.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.myapplication.data.model.Language
import com.example.myapplication.ui.screens.GuidedReadingPlayerScreen
import com.example.myapplication.ui.screens.HomeScreen
import com.example.myapplication.ui.screens.LanguageSelectionScreen
import com.example.myapplication.ui.screens.LoginScreen
import com.example.myapplication.ui.screens.SignupScreen
import com.example.myapplication.ui.screens.TopicDetailScreen
import com.example.myapplication.ui.screens.WelcomeScreen

@Composable
fun AppNavigation() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Screen.Welcome.route
    ) {
        composable(Screen.Welcome.route) {
            WelcomeScreen(
                onNavigateToLogin = {
                    navController.navigate(Screen.Login.route)
                },
                onNavigateToSignup = {
                    navController.navigate(Screen.Signup.route)
                }
            )
        }

        composable(Screen.Login.route) {
            LoginScreen(
                onLoginSuccess = { username ->
                    navController.navigate(Screen.LanguageSelection.route)
                },
                onNavigateToSignup = {
                    navController.navigate(Screen.Signup.route) {
                        popUpTo(Screen.Login.route) { inclusive = true }
                    }
                }
            )
        }

        composable(Screen.Signup.route) {
            SignupScreen(
                onSignupSuccess = { name ->
                    navController.navigate(Screen.LanguageSelection.route)
                },
                onNavigateToLogin = {
                    navController.navigate(Screen.Login.route) {
                        popUpTo(Screen.Signup.route) { inclusive = true }
                    }
                }
            )
        }

        composable(Screen.LanguageSelection.route) {
            LanguageSelectionScreen(
                onLanguageSelected = { selectedLang ->
                    navController.navigate(Screen.Home.createRoute(selectedLang.code, "Learner")) {
                        popUpTo(Screen.Welcome.route) { inclusive = true }
                    }
                }
            )
        }

        composable(
            route = Screen.Home.route,
            arguments = listOf(
                navArgument("langCode") { type = NavType.StringType },
                navArgument("username") { type = NavType.StringType }
            )
        ) { backStackEntry ->
            val langCode = backStackEntry.arguments?.getString("langCode") ?: "en"
            val username = backStackEntry.arguments?.getString("username") ?: "Learner"
            val language = Language.fromCode(langCode)

            HomeScreen(
                username = username,
                language = language,
                onChangeLanguage = {
                    navController.navigate(Screen.LanguageSelection.route)
                },
                onCategoryClick = { categoryId ->
                    navController.navigate(Screen.TopicDetail.createRoute(language.code, categoryId))
                },
                onStartLesson = { lessonId ->
                    navController.navigate(Screen.GuidedReadingPlayer.createRoute(lessonId, 100))
                },
                onLogout = {
                    navController.navigate(Screen.Welcome.route) {
                        popUpTo(Screen.Home.route) { inclusive = true }
                    }
                }
            )
        }

        composable(
            route = Screen.TopicDetail.route,
            arguments = listOf(
                navArgument("langCode") { type = NavType.StringType },
                navArgument("categoryId") { type = NavType.StringType }
            )
        ) { backStackEntry ->
            val langCode = backStackEntry.arguments?.getString("langCode") ?: "en"
            val categoryId = backStackEntry.arguments?.getString("categoryId") ?: "heritage"
            val language = Language.fromCode(langCode)

            TopicDetailScreen(
                categoryId = categoryId,
                language = language,
                onStartLesson = { lessonId, wpm ->
                    navController.navigate(Screen.GuidedReadingPlayer.createRoute(lessonId, wpm))
                },
                onBack = {
                    navController.popBackStack()
                }
            )
        }

        composable(
            route = Screen.GuidedReadingPlayer.route,
            arguments = listOf(
                navArgument("lessonId") { type = NavType.StringType },
                navArgument("wpm") { type = NavType.IntType }
            )
        ) { backStackEntry ->
            val lessonId = backStackEntry.arguments?.getString("lessonId") ?: ""
            val wpm = backStackEntry.arguments?.getInt("wpm") ?: 100

            GuidedReadingPlayerScreen(
                lessonId = lessonId,
                initialWpm = wpm,
                onBack = {
                    navController.popBackStack()
                }
            )
        }
    }
}
