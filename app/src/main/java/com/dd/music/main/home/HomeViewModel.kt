package com.dd.music.main.home

import Block
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import com.dd.base.base.BaseViewModel
import com.dd.base.ext.launch
import com.dd.music.Constant
import com.dd.music.bean.Banner
import com.dd.music.bean.HomeIconBean
import com.dd.music.net.HttpService
import kotlinx.coroutines.async


class HomeViewModel constructor(
    private var service: HttpService,
) : BaseViewModel() {

    var viewStates by mutableStateOf(HomeViewState(isRefreshing = false))
        private set

    init {
        getData()
    }
    private fun getData(){
        launch{
            val banner = async {
                service.getBanner().banners ?: emptyList()
            }
            val homeIcon = async {
                service.getHomeIcon().data ?: emptyList()
            }
            val homeData = async {
                service.getHomePage().data?.blocks ?: emptyList()
            }
            var recommendPlay: Block? = null
            var slidePlay: Block? = null
            for (item in homeData.await()) {
                when (item.showType) {
                    Constant.HOMEPAGE_SLIDE_PLAYLIST -> {
                        recommendPlay = item
                    }
                    Constant.HOMEPAGE_SLIDE_SONGLIST_ALIGN -> {
                        slidePlay = item
                    }
                }
            }
            viewStates = HomeViewState(false,banner.await(),homeIcon.await(),recommendPlay,slidePlay)
        }
    }
}


data class HomeViewState(
    val isRefreshing: Boolean = false,
    val banner: List<Banner> = emptyList(),
    val homeIcon: List<HomeIconBean> = emptyList(),
    val recommendPlay: Block? = null,
    val slidePlay: Block? = null
)