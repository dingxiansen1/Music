package com.dd.music.widget

import Resource
import androidx.annotation.DrawableRes
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.input.pointer.*
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.dd.base.theme.AppTheme
import com.dd.base.utils.sdp
import com.dd.music.R
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.VerticalPager
import com.google.accompanist.pager.rememberPagerState
import kotlinx.coroutines.delay

/**
 * 轮播图
 * [timeMillis] 停留时间
 * [loadImage] 加载中显示的布局
 * [onClick] 轮播图点击事件
 */
@ExperimentalPagerApi
@Composable
fun ScrollPlayList(
    list: List<Resource>?,
    timeMillis: Long = 3000,
    @DrawableRes loadImage: Int = R.mipmap.no_image,
    onClick: (resource: Resource) -> Unit
) {

    Column(
        modifier = Modifier
            .background(MaterialTheme.colors.background)
            .padding(20.sdp)
            .width(300.sdp)
    ) {

        if (list == null) {
            //加载中的图片
            AsyncImage(
                model = loadImage,
                modifier = Modifier
                    .fillMaxSize()
                    .clip(shape = RoundedCornerShape(50.sdp)),
                contentDescription = null,
                contentScale = ContentScale.Crop
            )
        } else {
            val pagerState = rememberPagerState(
                //初始页面
                initialPage = 0
            )

            //监听动画执行
            var executeChangePage by remember { mutableStateOf(false) }
            var currentPageIndex = 0

            //自动滚动
            LaunchedEffect(pagerState.currentPage, executeChangePage) {
                if (pagerState.pageCount > 0) {
                    delay(timeMillis)
                    //这里直接+1就可以循环，前提是infiniteLoop == true
                    pagerState.animateScrollToPage((pagerState.currentPage + 1) % (pagerState.pageCount))
                }
            }

            VerticalPager(
                count = list.size,
                state = pagerState,
                modifier = Modifier
                    .size(300.sdp)
                    .pointerInput(pagerState.currentPage) {
                        awaitPointerEventScope {
                            while (true) {
                                //PointerEventPass.Initial - 本控件优先处理手势，处理后再交给子组件
                                val event = awaitPointerEvent(PointerEventPass.Initial)
                                //获取到第一根按下的手指
                                val dragEvent = event.changes.firstOrNull()
                                when {
                                    //当前移动手势是否已被消费
                                    dragEvent!!.positionChangeConsumed() -> {
                                        return@awaitPointerEventScope
                                    }
                                    //是否已经按下(忽略按下手势已消费标记)
                                    dragEvent.changedToDownIgnoreConsumed() -> {
                                        //记录下当前的页面索引值
                                        currentPageIndex = pagerState.currentPage
                                    }
                                    //是否已经抬起(忽略按下手势已消费标记)
                                    dragEvent.changedToUpIgnoreConsumed() -> {
                                        //当页面没有任何滚动/动画的时候pagerState.targetPage为null，这个时候是单击事件
                                        if (pagerState.targetPage == null) return@awaitPointerEventScope
                                        //当pageCount大于1，且手指抬起时如果页面没有改变，就手动触发动画
                                        if (currentPageIndex == pagerState.currentPage && pagerState.pageCount > 1) {
                                            executeChangePage = !executeChangePage
                                        }
                                    }
                                }
                            }
                        }
                    }
                    .clip(RoundedCornerShape(50.sdp))
                    .clickable {//点击事件在clip后面，这样按下效果才会跟着被clip
                        with(list[pagerState.currentPage]) {
                            onClick.invoke(list[pagerState.currentPage])
                        }
                    }
                    .fillMaxSize(),
            ) { page ->
                AsyncImage(
                    model = list[page].uiElement.image?.imageUrl,
                    modifier = Modifier
                        .size(300.sdp)
                        .clip(RoundedCornerShape(50.sdp)),
                    contentScale = ContentScale.Crop,
                    contentDescription = null
                )
            }
            Text(
                text = list[pagerState.currentPage].uiElement.mainTitle?.title ?: "",
                fontSize = 12.sp,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(5.dp),
                maxLines = 2,
                overflow = TextOverflow.Ellipsis,
                style = TextStyle(color = AppTheme.colors.textPrimary)
            )
        }

    }

}