package com.demo.code.activities

import android.os.Bundle
import androidx.lifecycle.lifecycleScope
import com.demo.code.base.BaseActivity
import com.demo.code.databinding.ActivitySuspendingFuncBinding
import kotlinx.coroutines.launch
import kotlin.concurrent.thread
import kotlin.coroutines.suspendCoroutine

class SuspendingFuncActivity  : BaseActivity() {

    override fun getToolbarTitle() = "Suspending Functions"

    private lateinit var binding: ActivitySuspendingFuncBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySuspendingFuncBinding.inflate(layoutInflater)
        setContentView(binding.root)
        hideUpButton()
        setOnClickListeners()
    }

    private fun setOnClickListeners() {
        binding.apply {
            btnLaunchId.setOnClickListener {
                simpleDemo()
            }
        }
    }

    private fun simpleDemo() {
        lifecycleScope.launch {
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


    data class User(val userId:String,val userName:String)



}
