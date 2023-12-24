package com.demo.code.modules.legacycode

import android.os.AsyncTask
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import java.io.IOException
import java.net.MalformedURLException
import kotlin.coroutines.CoroutineContext
import kotlin.coroutines.resume
import kotlin.coroutines.suspendCoroutine


class LegacyCallbackSampleTwo(
    override val coroutineContext: CoroutineContext
) : CoroutineScope {

    fun initiateDemo() {
        launch {
            val user = getUser("111")
            println(user.userName)
        }
    }

    private suspend fun getUser(id: String): User = suspendCoroutine {
        try {
            val result = MyTask().execute(id).get()
            it.resume(result)
        } catch (e: Exception) {
            e.printStackTrace()
            println(e.message)
        }
    }

    class MyTask : AsyncTask<String?, Void?, User>() {
        protected override fun doInBackground(vararg userId: String?): User? {
            try {
                return User(userId.toString(), "Async User")
            } catch (e: MalformedURLException) {
                e.printStackTrace()
            } catch (e: IOException) {
                e.printStackTrace()
            }
            return null
        }

    }
}