package com.lewis.bnztest.data.dto

import com.google.gson.annotations.SerializedName

data class DataStoreDto(
    @SerializedName("help")
    val help: String? = null,
    @SerializedName("success")
    val success: Boolean = false,
    @SerializedName("result")
    val result: ResultDto? = null,
)