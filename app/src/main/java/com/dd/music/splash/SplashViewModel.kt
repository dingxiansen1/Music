package com.dd.music.splash

import Banner
import Block
import ExtInfo
import HomePage
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import com.dd.base.base.BaseViewModel
import com.dd.base.ext.launch
import com.dd.base.net.RxHttpUtils
import com.dd.base.utils.JsonUtils
import com.dd.base.utils.log.LogUtils
import com.dd.music.Constant
import com.dd.music.bean.HomeIconBean
import com.dd.music.main.home.HomeModel
import com.dd.music.main.home.HomeViewState
import com.dd.music.net.API
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.async
import kotlinx.serialization.decodeFromString
import javax.inject.Inject

@HiltViewModel
class SplashViewModel @Inject constructor(
) : BaseViewModel() {

    fun getData() {
        launch {
            val homeIcon = async {
                RxHttpUtils.getAwait<List<HomeIconBean>>(API.HOME_ICON) ?: emptyList()
            }
            val homeData = async {
                RxHttpUtils.getAwait<HomePage>(API.HOME_PAGE)?.blocks ?: emptyList()
            }
            var recommendPlay: Block? = null
            var banner: List<Banner> = emptyList()
            var slidePlay: Block? = null
            for (item in homeData.await()) {
                when (item.showType) {
                    Constant.HOMEPAGE_BANNER -> {
                        LogUtils.d(item.extInfo)
                        banner =
                            JsonUtils.jsonDecoder.decodeFromString<ExtInfo>(item.extInfo.toString()).banners!!
                    }
                    Constant.HOMEPAGE_SLIDE_PLAYLIST -> {
                        recommendPlay = item
                    }
                    Constant.HOMEPAGE_SLIDE_SONGLIST_ALIGN -> {
                        slidePlay = item
                    }
                }
            }
            HomeModel.saveHomeData(HomeViewState(false, banner, homeIcon.await(), recommendPlay, slidePlay))
        }
    }
}
