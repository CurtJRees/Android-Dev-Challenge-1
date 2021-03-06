/*
 * Copyright 2021 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
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
