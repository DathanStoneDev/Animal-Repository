package com.devstone.randomanimalfacts.util.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.devstone.randomanimalfacts.presentation.main.MainScreen
import com.devstone.randomanimalfacts.presentation.saved_facts.SavedFactsScreen
import com.devstone.randomanimalfacts.presentation.selected_fact.SelectedFactScreen

@Composable
fun Navigation(navController: NavHostController) {
    NavHost(navController = navController, startDestination = Routes.MAIN_SCREEN) {
        composable(Routes.MAIN_SCREEN) {
            MainScreen(navController)
        }
        composable(Routes.SAVED_FACTS_SCREEN) {
            SavedFactsScreen(navController)
        }
        composable(
            Routes.SELECTED_FACT_SCREEN + "?id={id}",
            listOf(
                navArgument("id") {
                    type = NavType.IntType
                    defaultValue = 0
                }
            )
        ) {
            SelectedFactScreen(navController)
        }
    }
}