package com.saltwortdevs.myfirstcomposeapp.components.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.saltwortdevs.myfirstcomposeapp.components.navigation.model.SettingModel
import com.saltwortdevs.myfirstcomposeapp.components.navigation.types.createNavType
import com.saltwortdevs.myfirstcomposeapp.components.navigation.types.settingModelType
import kotlin.reflect.typeOf

// NavigationWrapper.kt
@Composable
fun NavigationWrapper(modifier: Modifier = Modifier) {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Login) {
        composable<Login> {
            LoginScreen(navigateToDetail = { navController.navigate(Home) })
        }
        composable<Home> {
            HomeScreen(backTo = { navController.popBackStack() }, navigateToDetail = {id -> navController.navigate(Detail(id = id))})
        }
        composable<Detail> { navBackStackEntry ->
            val detail = navBackStackEntry.toRoute<Detail>()
            DetailScreen(detail.id, navigateToSettings = {navController.navigate(Settings(it)) })
        }
        composable<Settings>(typeMap = mapOf(typeOf<SettingModel>() to createNavType<SettingModel>())) { navBackStackEntry ->
            val setting = navBackStackEntry.toRoute<Settings>()
            SettingsScreen(settingsModel =setting.settingModel , {
                navController.navigate(Login) {
                    popUpTo<Login>{inclusive = true}
                }
            })
        }
    }
}