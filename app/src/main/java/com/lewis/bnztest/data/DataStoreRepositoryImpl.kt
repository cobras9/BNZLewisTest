package com.lewis.bnztest.data

import com.lewis.bnztest.domain.DataStoreBo
import com.lewis.bnztest.domain.mapToBo
import com.lewis.bnztest.util.IoDispatcher
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class DataStoreRepositoryImpl @Inject constructor(
    private val dataStoreService: DataStoreService,
    @IoDispatcher val ioDispatcher: CoroutineDispatcher,
) : DataStoreRepository {
    override suspend fun loadData(resourceId: String, limit: Int): Flow<DataStoreBo> {
        return flow<DataStoreBo> {
            dataStoreService.getDataStore(resourceId = resourceId, limit = limit).mapToBo()
        }.flowOn(ioDispatcher)
    }
}