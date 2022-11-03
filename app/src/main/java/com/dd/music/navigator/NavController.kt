package com.dd.music.navigator

import androidx.compose.runtime.*
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun NavController(){
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = RouteName.Main) {
     // composable(RouteName.Main) { MainPage(navController) } //主页面

    }

}