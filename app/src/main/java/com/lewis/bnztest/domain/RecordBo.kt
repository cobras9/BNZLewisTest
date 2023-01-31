package com.lewis.bnztest.domain

import com.lewis.bnztest.data.dto.RecordDto

data class RecordBo(
    val id: Long? = null,
    val schoolID: Long? = null,
    val orgName: String? = null,
    val telephone: String? = null,
    val fax: String? = null,
    val email: String? = null,
)

fun RecordDto.mapToBo(): RecordBo {
    return RecordBo(
        id = this.id,
        schoolID = this.schoolID,
        orgName = this.orgName,
        telephone = this.telephone,
        fax = this.fax,
        email = this.email,
    )
}