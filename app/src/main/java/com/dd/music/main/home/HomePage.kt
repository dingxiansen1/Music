@file:OptIn(ExperimentalPagerApi::class)

package com.dd.music.main.home

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material.ScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.dd.base.ext.isNotNull
import com.dd.base.ext.showToast
import com.dd.base.utils.sdp
import com.dd.base.widget.SearchBar
import com.dd.base.widget.SearchBarNotClickable
import com.dd.music.main.home.ui.HomeIconPage
import com.dd.music.main.home.ui.RecommendPlayView
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
    val homeIcon = viewStates.homeIcon
    val recommendPlay = viewStates.recommendPlay
    val slidePlay = viewStates.slidePlay
    Column(Modifier.fillMaxSize()) {

        SearchBarNotClickable(hint = "周杰伦") {
            showToast("跳转搜索页")
        }

        AnimatedVisibility(banners.isNotEmpty()) {
            Banner(list = banners) { url, title ->
                showToast("暂未开发$title")
            }
        }
        AnimatedVisibility(homeIcon.isNotEmpty()) {
            LazyRow {
                items(homeIcon.size) { index ->
                    HomeIconPage(homeIcon[index])
                }
            }
            Spacer(
                modifier = Modifier
                    .height(30.sdp)
                    .fillMaxWidth()
            )
        }
        AnimatedVisibility(recommendPlay.isNotNull()) {
            RecommendPlayView(recommendPlay!!)
        }
        AnimatedVisibility(slidePlay.isNotNull()) {
            SlidePlayView(slidePlay!!)
        }
    }
}



