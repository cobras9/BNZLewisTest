package com.lewis.bnztest.di


import com.lewis.bnztest.data.DataStoreRepository
import com.lewis.bnztest.data.DataStoreRepositoryImpl
import com.lewis.bnztest.data.DataStoreService
import com.lewis.bnztest.util.DefaultDispatcher
import com.lewis.bnztest.util.IoDispatcher
import com.lewis.bnztest.util.MainDispatcher
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers

@InstallIn(SingletonComponent::class)
@Module
object ApplicationModule {

    @Provides
    fun provideSchoolRepository(
        dataStoreService: DataStoreService,
    ): DataStoreRepository {
        return DataStoreRepositoryImpl(dataStoreService)
    }

    @DefaultDispatcher
    @Provides
    fun providesDefaultDispatcher(): CoroutineDispatcher = Dispatchers.Default

    @IoDispatcher
    @Provides
    fun providesIoDispatcher(): CoroutineDispatcher = Dispatchers.IO

    @MainDispatcher
    @Provides
    fun providesMainDispatcher(): CoroutineDispatcher = Dispatchers.Main
}