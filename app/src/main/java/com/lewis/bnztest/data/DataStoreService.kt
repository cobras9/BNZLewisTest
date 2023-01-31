package com.lewis.bnztest.data

import com.lewis.bnztest.data.dto.DataStoreDto
import retrofit2.http.GET
import retrofit2.http.Query

interface DataStoreService {
    // The path could have been set globally via strings or properties for services to consume
    @GET("datastore_search")
    fun getDataStore(@Query("resource_id") resourceId: String, @Query("limit") limit: Int) :DataStoreDto
}