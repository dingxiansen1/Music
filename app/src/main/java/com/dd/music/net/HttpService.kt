package com.dd.music.net

import HomePage
import com.dd.music.bean.BaseBean
import com.dd.music.bean.Banner
import com.dd.music.bean.HomeIconBean
import com.dd.music.bean.basebanner
import retrofit2.http.GET

/**
 * 网络请求接口
 * 注意：接口前无需加斜杠
 */
interface  HttpService {

    companion object {
        const val url = "http://111.67.192.132:3000"
    }

    @GET("/banner")
    suspend fun getBanner(): basebanner<List<Banner>?>

    @GET("/homepage/dragon/ball")
    suspend fun getHomeIcon(): BaseBean<List<HomeIconBean>?>

    @GET("/homepage/block/page")
    suspend fun getHomePage(): BaseBean<HomePage?>
}
