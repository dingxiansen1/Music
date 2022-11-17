@file:OptIn(ExperimentalPagerApi::class)

package com.dd.music.main.home

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.material.ScaffoldState
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.dd.base.ext.isNotNull
import com.dd.base.ext.showToast
import com.dd.music.main.home.ui.SlidePlayView
import com.dd.music.widget.Banner
import com.google.accompanist.pager.ExperimentalPagerApi
import kotlinx.coroutines.CoroutineScope


@Composable
fun HomePage(
    navCtrl: NavHostController,
    scaffoldState: ScaffoldState,
    scope: CoroutineScope
) {
    val viewModel: HomeViewModel = hiltViewModel()
    val viewStates = viewModel.viewStates
    val banners = viewStates.banner
    val slidePlay = viewStates.slidePlay
    //推荐歌曲 showType = HOMEPAGE_SLIDE_SONGLIST_ALIGN

    AnimatedVisibility (banners.isNotEmpty()) {
        Banner(list = banners) { url, title ->
            showToast("暂未开发$title")
        }
    }
    AnimatedVisibility (slidePlay.isNotNull()) {
        SlidePlayView(slidePlay!!)
    }
}



