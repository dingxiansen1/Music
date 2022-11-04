package com.dd.music.main.find

import androidx.compose.material.ScaffoldState
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import kotlinx.coroutines.CoroutineScope

@Composable
fun FindPage(
    navCtrl: NavHostController,
    scaffoldState: ScaffoldState,
    scope: CoroutineScope
) {
    Text(text = "发现")
}