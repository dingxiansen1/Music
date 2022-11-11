package com.dd.music.main.home

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.material.ScaffoldState
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.dd.base.ext.isNotNull
import com.dd.music.main.home.ui.SlidePlayView
import kotlinx.coroutines.CoroutineScope


@Composable
fun HomePage(
    navCtrl: NavHostController,
    scaffoldState: ScaffoldState,
    scope: CoroutineScope
) {
    val viewModel: HomeViewModel = hiltViewModel()
    val viewStates = viewModel.viewStates
    val slidePlay = viewStates.slidePlay
    //推荐歌曲 showType = HOMEPAGE_SLIDE_SONGLIST_ALIGN
    AnimatedVisibility (slidePlay.isNotNull()) {
        SlidePlayView(slidePlay!!)
    }
}



