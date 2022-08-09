package com.demo.code.activities

import android.os.Bundle
import androidx.lifecycle.lifecycleScope
import com.demo.code.base.BaseActivity
import com.demo.code.databinding.ActivitySuspendingFuncBinding
import com.demo.code.modules.legacycode.LegacyCallbackSampleOne
import com.demo.code.modules.legacycode.LegacyCallbackSampleTwo
import com.demo.code.modules.legacycode.User
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
            LegacyCallbackSampleTwo(this.coroutineContext).initiateDemo()
        }
    }
}
