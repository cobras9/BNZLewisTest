package com.lewis.bnztest.ui.school

import com.lewis.bnztest.domain.RecordBo

data class RecordUio(
    val id: Long? = null,
    val schoolID: Long? = null,
    val orgName: String? = null,
    val telephone: String? = null,
    val fax: String? = null,
    val email: String? = null,
)

fun RecordBo.mapToUio(): RecordUio {
    return RecordUio(
        id = this.id,
        schoolID = this.schoolID,
        orgName = this.orgName,
        telephone = this.telephone,
        fax = this.fax,
        email = this.email,
    )
}