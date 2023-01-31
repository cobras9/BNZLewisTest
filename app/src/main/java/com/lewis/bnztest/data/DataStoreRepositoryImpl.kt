package com.lewis.bnztest.data

import com.lewis.bnztest.domain.DataStoreBo
import com.lewis.bnztest.domain.mapToBo
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class DataStoreRepositoryImpl @Inject constructor(
    private val dataStoreService: DataStoreService,
) : DataStoreRepository {
    override suspend fun loadData(resourceId: String, limit: Int): Flow<DataStoreBo?> {
        return flow<DataStoreBo> {
            val result = dataStoreService.getDataStore(resourceId = resourceId, limit = limit)
            if (result.isSuccessful) {
                result.body()?.mapToBo()?.let { emit(it) }
            } else {
                // Other error handling
                emit(DataStoreBo())
            }
        }
    }
}