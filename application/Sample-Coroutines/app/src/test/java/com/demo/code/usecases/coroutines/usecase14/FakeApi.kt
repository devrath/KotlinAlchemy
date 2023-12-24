package com.demo.code.usecases.coroutines.usecase14

import com.demo.code.mock.AndroidVersion
import com.demo.code.mock.MockApi
import com.demo.code.mock.VersionFeatures
import com.demo.code.mock.mockAndroidVersions
import com.demo.code.utils.EndpointShouldNotBeCalledException
import kotlinx.coroutines.delay

class FakeApi : MockApi {

    override suspend fun getRecentAndroidVersions(): List<AndroidVersion> {
        delay(1)
        return mockAndroidVersions
    }

    override suspend fun getAndroidVersionFeatures(apiLevel: Int): VersionFeatures {
        throw EndpointShouldNotBeCalledException()
    }
}