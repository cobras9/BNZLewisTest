package com.lewis.bnztest.domain

import com.lewis.bnztest.data.dto.ResultDto

data class ResultBo(
    val records: List<RecordBo>? = null,
    val total: Int? = null,
)

fun ResultDto.mapToBo(): ResultBo {
    return ResultBo(
        records = this.records?.map {  it.mapToBo()},
        total = this.total,
    )
}