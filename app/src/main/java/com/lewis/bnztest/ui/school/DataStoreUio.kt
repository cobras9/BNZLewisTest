package com.lewis.bnztest.ui.school

import com.lewis.bnztest.domain.DataStoreBo

data class DataStoreUio(
    val help: String? = null,
    val success: Boolean = false,
    val result: ResultUio? = null,
)

fun DataStoreBo.mapToUio(): DataStoreUio {
    return DataStoreUio(
        help = this.help,
        success = this.success,
        result = this.result?.mapToUio(),
    )
}