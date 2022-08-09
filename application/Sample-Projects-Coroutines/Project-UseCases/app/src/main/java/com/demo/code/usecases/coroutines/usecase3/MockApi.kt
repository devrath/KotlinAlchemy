package com.demo.code.usecases.coroutines.usecase3

import com.google.gson.Gson
import com.demo.code.mock.createMockApi
import com.demo.code.mock.mockVersionFeaturesAndroid10
import com.demo.code.mock.mockVersionFeaturesOreo
import com.demo.code.mock.mockVersionFeaturesPie
import com.demo.code.utils.MockNetworkInterceptor

fun mockApi() = createMockApi(
    MockNetworkInterceptor()
        .mock(
            "http://localhost/android-version-features/27",
            Gson().toJson(mockVersionFeaturesOreo),
            200,
            1000
        )
        .mock(
            "http://localhost/android-version-features/28",
            Gson().toJson(mockVersionFeaturesPie),
            200,
            1000
        )
        .mock(
            "http://localhost/android-version-features/29",
            Gson().toJson(mockVersionFeaturesAndroid10),
            200,
            1000
        )
)