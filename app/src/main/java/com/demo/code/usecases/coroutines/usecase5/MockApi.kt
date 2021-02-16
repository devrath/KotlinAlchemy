package com.demo.code.usecases.coroutines.usecase5

import com.google.gson.Gson
import com.demo.code.mock.createMockApi
import com.demo.code.mock.mockAndroidVersions
import com.demo.code.utils.MockNetworkInterceptor

fun mockApi() = createMockApi(
    MockNetworkInterceptor()
        .mock(
            "http://localhost/recent-android-versions",
            Gson().toJson(mockAndroidVersions),
            200,
            1000
        )
)