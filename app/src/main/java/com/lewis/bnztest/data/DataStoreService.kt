package com.lewis.bnztest.data

import com.lewis.bnztest.data.dto.DataStoreDto
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface DataStoreService {
    // The
    // path could have been set globally via strings or properties for services to consume

    @GET("https://catalogue.data.govt.nz/api/3/action/datastore_search")
    suspend fun getDataStore(
        @Query("resource_id") resourceId: String,
        @Query("limit") limit: Int
    ): Response<DataStoreDto>
}