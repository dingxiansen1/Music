package com.dd.music.main.home

import Block
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import com.dd.base.base.BaseViewModel
import com.dd.music.bean.Banner
import com.dd.music.bean.HomeIconBean


class HomeViewModel : BaseViewModel() {

    var viewStates by mutableStateOf(HomeViewState(isRefreshing = false))
        private set

    init {

    }

}


data class HomeViewState(
    val isRefreshing: Boolean = false,
    val banner: List<Banner> = emptyList(),
    val homeIcon: List<HomeIconBean> = emptyList(),
    val recommendPlay: Block? = null,
    val slidePlay: Block? = null
)