package com.demo.code.activities

import android.os.Bundle
import com.demo.code.base.BaseActivity
import com.demo.code.databinding.ActivitySuspendingFuncBinding

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

            }
        }
    }

}