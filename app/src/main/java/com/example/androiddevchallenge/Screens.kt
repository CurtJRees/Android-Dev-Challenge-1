package com.example.androiddevchallenge

import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavType
import androidx.navigation.compose.navArgument

sealed class Screen(val route: String) {
    object HomeScreen : Screen("Home")
    object DetailScreen : Screen("Detail")
}

const val PET_ID_KEY = "pet_id"
val petIdNavArgument = navArgument(PET_ID_KEY) { type = NavType.IntType }


/**
 * Hack/Workaround to get route from NavBackStackEntry
 * Taken KEY_ROUTE from `androidx.navigation.compose.NavHostController.kt`
 */

private const val KEY_ROUTE = "android-support-nav:controller:route"
fun NavBackStackEntry?.getRoute(): String? = this?.let {
    it.arguments?.getString(KEY_ROUTE)
}