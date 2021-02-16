package com.demo.code.usecases.coroutines.usecase6

import com.demo.code.mock.AndroidVersion
import com.demo.code.mock.MockApi
import com.demo.code.mock.VersionFeatures
import com.demo.code.mock.mockAndroidVersions
import com.demo.code.utils.EndpointShouldNotBeCalledException
import kotlinx.coroutines.delay
import java.io.IOException

class FakeSuccessOnThirdAttemptApi(private val responseDelay: Long) : MockApi {

    var requestCount = 0

    override suspend fun getRecentAndroidVersions(): List<AndroidVersion> {
        requestCount++
        delay(responseDelay)
        if (requestCount < 3) {
            throw IOException()
        }
        return mockAndroidVersions
    }

    override suspend fun getAndroidVersionFeatures(apiLevel: Int): VersionFeatures {
        throw EndpointShouldNotBeCalledException()
    }
}