package com.dd.music.main

import android.annotation.SuppressLint
import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.navigation.NavHostController
import com.dd.base.ui.theme.AppTheme
import com.dd.base.ui.theme.ComposeAppTheme
import com.dd.base.ui.theme.Themem
import com.dd.base.utils.sdp
import com.dd.music.main.find.FindPage
import com.dd.music.main.home.HomePage
import com.dd.music.main.mine.MinePage

@OptIn(ExperimentalAnimationApi::class)
@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun MainPage(navCtrl: NavHostController) {
    val scaffoldState = rememberScaffoldState()
    val scope = rememberCoroutineScope()
    var selectedItem by remember { mutableStateOf(0) }
    val items = listOf("首页", "歌手", "我的")
    ComposeAppTheme(themeType = Themem.themeTypeState.value) {
        Scaffold(
            scaffoldState = scaffoldState,
            drawerContent = {
                //   MainDrawerPage(scaffoldState, scope)
            },
            //抽屉手势关闭，默认开启（开始后滑动屏幕打开抽屉）
            drawerGesturesEnabled = false,
            bottomBar = {
                BottomNavigation(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(150.sdp),
                    backgroundColor = AppTheme.colors.background
                ) {
                    items.forEachIndexed { index, item ->
                        BottomNavigationItem(
                            icon = {
                                when (index) {
                                    0 -> Icon(Icons.Filled.Home, contentDescription = null)
                                    1 -> Icon(Icons.Filled.Favorite, contentDescription = null)
                                    else -> Icon(Icons.Filled.Person, contentDescription = null)
                                }
                            },
                            label = { Text(item) },
                            selectedContentColor = AppTheme.colors.error,
                            unselectedContentColor = AppTheme.colors.textPrimary,
                            selected = selectedItem == index,
                            onClick = { selectedItem = index }
                        )
                    }
                }
            },
        ) {
            // 此处需要编写主界面
            AnimatedContent(targetState = selectedItem) { targetState ->
                when (targetState) {
                    0 -> HomePage(navCtrl, scaffoldState = scaffoldState, scope = scope)
                    1 -> FindPage(navCtrl, scaffoldState = scaffoldState, scope = scope)
                    else -> MinePage(navCtrl, scaffoldState = scaffoldState, scope = scope)
                }
            }
        }
    }
}