package com.lewis.bnztest.ui.school

import com.lewis.bnztest.domain.ResultBo


data class ResultUio(
    val records: List<RecordUio>? = null,
    val total: Int? = null,
)

fun ResultBo.mapToUio(): ResultUio {
    return ResultUio(
        records = this.records?.map { it.mapToUio() },
        total = this.total,
    )
}