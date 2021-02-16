package com.demo.code.usecases.coroutines.usecase1

import com.demo.code.mock.AndroidVersion
import com.demo.code.mock.MockApi
import com.demo.code.mock.VersionFeatures
import com.demo.code.mock.mockAndroidVersions
import com.demo.code.utils.EndpointShouldNotBeCalledException

class FakeSuccessApi() : MockApi {

    override suspend fun getRecentAndroidVersions(): List<AndroidVersion> {
        return mockAndroidVersions
    }

    override suspend fun getAndroidVersionFeatures(apiLevel: Int): VersionFeatures {
        throw EndpointShouldNotBeCalledException()
    }
}