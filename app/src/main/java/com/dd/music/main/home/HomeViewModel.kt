package com.dd.music.main.home

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import com.dd.base.base.BaseViewModel
import com.dd.base.ext.launch
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


@HiltViewModel
class HomeViewModel @Inject constructor(
) : BaseViewModel() {
    var viewStates by mutableStateOf(HomeViewState(isRefreshing = false))
        private set

    init {
        getData()
    }

    private fun getData() {
        launch {
            viewStates = HomeModel.getHomeData()
        }
    }
}