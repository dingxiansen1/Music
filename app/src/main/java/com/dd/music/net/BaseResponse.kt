package com.dd.music.net

class BaseResponse<T> {
    var code: String? = "0"
    var msg: String? = null
    var data: T? = null
}