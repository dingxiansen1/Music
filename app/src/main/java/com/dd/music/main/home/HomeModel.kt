package com.dd.music.main.home

import Banner
import Block
import com.dd.base.utils.DataStoreUtils
import com.dd.base.utils.JsonUtils
import com.dd.music.bean.HomeIconBean
import kotlinx.serialization.Serializable
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString

class HomeModel {

    companion object {
        private const val HOME_DATA = "home_data"
        suspend fun saveHomeData(data: HomeViewState) {
            val string = JsonUtils.jsonDecoder.encodeToString(data)
            DataStoreUtils.saveStringData(HOME_DATA, string)
        }

        fun getHomeData(): HomeViewState {

            val string = DataStoreUtils.getSyncData(HOME_DATA,"");

            return JsonUtils.jsonDecoder.decodeFromString(string)
        }
    }

}

@Serializable
data class HomeViewState(
    val isRefreshing: Boolean = false,
    val banner: List<Banner> = emptyList(),
    val homeIcon: List<HomeIconBean> = emptyList(),
    val recommendPlay: Block? = null,
    val slidePlay: Block? = null
)