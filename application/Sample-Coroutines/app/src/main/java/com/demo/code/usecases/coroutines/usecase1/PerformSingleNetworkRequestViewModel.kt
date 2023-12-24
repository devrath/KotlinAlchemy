package com.demo.code.usecases.coroutines.usecase1

import androidx.lifecycle.viewModelScope
import com.demo.code.base.BaseViewModel
import com.demo.code.mock.MockApi
import kotlinx.coroutines.launch
import timber.log.Timber

class PerformSingleNetworkRequestViewModel(
    private val mockApi: MockApi = mockApi()
) : BaseViewModel<UiState>() {

    fun performSingleNetworkRequest() {
        uiState.value = UiState.Loading
        viewModelScope.launch {
            try {
                val recentAndroidVersions = mockApi.getRecentAndroidVersions()
                uiState.value = UiState.Success(recentAndroidVersions)
            } catch (exception: Exception) {
                Timber.e(exception)
                uiState.value = UiState.Error("Network Request failed!")
            }
        }
    }
}