package com.lewis.bnztest

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.lewis.bnztest.data.DataStoreRepository
import com.lewis.bnztest.ui.school.RecordUio
import com.lewis.bnztest.ui.school.mapToUio
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainActivityViewModel @Inject constructor(
    val repository: DataStoreRepository
) : ViewModel() {
    private val _schoolList: MutableLiveData<List<RecordUio>> =
        MutableLiveData<List<RecordUio>>()
    val schoolList: LiveData<List<RecordUio>>
        get() = _schoolList

    suspend fun loadSchoolData(resourceId: String, limit: String) {
        viewModelScope.launch() {
            repository.loadData(resourceId, limit.toInt()).collect {
                _schoolList.postValue(it?.mapToUio()?.result?.records)
            }
        }
    }
}