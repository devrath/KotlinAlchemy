package com.demo.code.modules.legacycode

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import kotlin.concurrent.thread
import kotlin.coroutines.CoroutineContext
import kotlin.coroutines.suspendCoroutine

class LegacyCallbackSampleOne(
    override val coroutineContext: CoroutineContext
    ) : CoroutineScope{


    fun initiateDemo() {
        launch {
            getUser("111")
        }
    }

    private suspend fun getUser(id: String): User = suspendCoroutine {
        getUserFromNetworkCallback("101") { user, error ->
            user?.run { println(this.userName) }
            error?.run { println(this.message) }
        }
    }


    private fun getUserFromNetworkCallback(
        userId: String,
        onUserResponse: (User?, Throwable?) -> Unit) {
        thread {
            try {
                Thread.sleep(1000) // ---> Simulating the network delay
                val user = User(userId, "Test User")

                onUserResponse(user, null)
            } catch (error: Throwable) {
                onUserResponse(null, error)
            }
        }
    }


}