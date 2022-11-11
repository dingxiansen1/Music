package com.dd.music.utils

import kotlinx.serialization.json.Json

class JsonUtils {

    companion object{
       val jsonDecoder by lazy {
           Json {
               coerceInputValues = true
               ignoreUnknownKeys = true
               explicitNulls = false
           }
       }
    }

}