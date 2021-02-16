package com.demo.code.usecases.coroutines.usecase14

import com.demo.code.mock.AndroidVersion
import com.demo.code.mock.MockApi
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import timber.log.Timber

class AndroidVersionRepository(
    private var database: AndroidVersionDao,
    private val scope: CoroutineScope,
    private val api: MockApi = mockApi()
) {

    suspend fun getLocalAndroidVersions(): List<AndroidVersion> {
        return database.getAndroidVersions().mapToUiModelList()
    }

    suspend fun loadAndStoreRemoteAndroidVersions(): List<AndroidVersion> {
        return scope.async {
            val recentVersions = api.getRecentAndroidVersions()
                Timber.d("Recent Android versions loaded")
                for (recentVersion in recentVersions) {
                    Timber.d("Insert $recentVersion to database")
                    database.insert(recentVersion.mapToEntity())
                }
                recentVersions
            }.await()
        }

    fun clearDatabase() {
        scope.launch {
            database.clear()
        }
    }
}