package com.lewis.bnztest

import androidx.compose.ui.unit.ExperimentalUnitApi
import com.lewis.bnztest.data.DataStoreRepository
import com.lewis.bnztest.data.DataStoreRepositoryImpl
import com.lewis.bnztest.data.DataStoreService
import com.lewis.bnztest.domain.DataStoreBo
import com.lewis.bnztest.domain.RecordBo
import com.lewis.bnztest.domain.ResultBo
import com.lewis.bnztest.ui.school.DataStoreUio
import com.lewis.bnztest.ui.school.RecordUio
import com.lewis.bnztest.ui.school.ResultUio
import com.lewis.bnztest.ui.school.mapToUio
import junit.framework.TestCase.assertEquals
import junit.framework.TestCase.assertNotNull
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.newSingleThreadContext
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.test.setMain
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito.*
import org.mockito.MockitoAnnotations


@ExperimentalUnitApi
class MainActivityViewModelTest {

    private val mockDataStoreRepository = MockDataStoreRepository()


    @Mock
    lateinit var viewModel: MainActivityViewModel
    private val mainThreadSurrogate = newSingleThreadContext("UI thread")
    private val RESOURCE_ID = "123"
    private val LIMIT = "20"

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        viewModel = MainActivityViewModel(mockDataStoreRepository)
        Dispatchers.setMain(mainThreadSurrogate)
    }

    @Test
    fun `GIVEN page loads WHEN page loaded THEN school list should be displayed`() {
        runBlocking {
            viewModel.loadSchoolData(RESOURCE_ID, LIMIT)
            assertEquals(1, viewModel.schoolList.value?.size)
        }

    }
}

class MockDataStoreRepository : DataStoreRepository {
    private val testData =
        DataStoreBo(result = ResultBo(records = listOf(RecordBo(id = 1, orgName = "aa"))))

    override suspend fun loadData(resourceId: String, limit: Int): Flow<DataStoreBo?> {
        return flow {
            emit(testData)
        }
    }

}