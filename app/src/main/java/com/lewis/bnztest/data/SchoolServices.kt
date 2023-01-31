package com.lewis.bnztest.data

import retrofit2.http.GET
import retrofit2.http.Query

interface SchoolService {
    // The path could have been set globally via strings or properties for services to consume
    @GET("https://catalogue.data.govt.nz/api/3/action/datastore_search")
    fun getSchools(@Query("resource_id") resourceId: String, @Query("limit") limit: Int)
}