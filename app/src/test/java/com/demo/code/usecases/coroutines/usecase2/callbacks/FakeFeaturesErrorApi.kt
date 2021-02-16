package com.demo.code.usecases.coroutines.usecase2.callbacks

import com.demo.code.mock.AndroidVersion
import com.demo.code.mock.VersionFeatures
import com.demo.code.mock.mockAndroidVersions
import retrofit2.Call
import retrofit2.mock.Calls
import java.io.IOException

class FakeFeaturesErrorApi : CallbackMockApi {

    override fun getRecentAndroidVersions(): Call<List<AndroidVersion>> {
        return Calls.response(mockAndroidVersions)
    }

    override fun getAndroidVersionFeatures(apiLevel: Int): Call<VersionFeatures> {
        return Calls.failure(IOException())
    }
}