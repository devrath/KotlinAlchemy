package com.demo.code.usecases.coroutines.usecase2

import com.google.gson.Gson
import com.demo.code.mock.createMockApi
import com.demo.code.mock.mockAndroidVersions
import com.demo.code.mock.mockVersionFeaturesAndroid10
import com.demo.code.utils.MockNetworkInterceptor

fun mockApi() = createMockApi(
    MockNetworkInterceptor()
        .mock(
            "http://localhost/recent-android-versions",
            Gson().toJson(mockAndroidVersions),
            200,
            1500
        )
        .mock(
            "http://localhost/android-version-features/29",
            Gson().toJson(mockVersionFeaturesAndroid10),
            200,
            1500
        )
)