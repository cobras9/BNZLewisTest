package com.lewis.bnztest.data

import com.lewis.bnztest.domain.DataStoreBo
import kotlinx.coroutines.flow.Flow

interface DataStoreRepository {
    suspend fun loadData(resourceId: String, limit: Int): Flow<DataStoreBo?>
}