package com.lewis.bnztest.domain

import com.lewis.bnztest.data.dto.DataStoreDto

data class DataStoreBo(
    val help: String? = null,
    val success: Boolean = false,
    val result: ResultBo? = null,
)

fun DataStoreDto.mapToBo():DataStoreBo{
    return DataStoreBo(
        help = this.help,
        success = this.success,
        result =this.result?.mapToBo(),
    )
}