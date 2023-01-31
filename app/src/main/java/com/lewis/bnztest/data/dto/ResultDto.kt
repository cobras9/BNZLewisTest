package com.lewis.bnztest.data.dto

import com.google.gson.annotations.SerializedName

data class ResultDto(
    @SerializedName("records")
    val records: List<RecordDto>? = null,

    @SerializedName("total")
    val total: Int? = null,

    // These are probably going to be important for pagination,
    // but setting a high limit for now so will ignore these for now
    // @SerializedName("fields")
    // @SerializedName("_links")
)

