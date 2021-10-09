package com.demo.code.activities

import android.os.Bundle
import com.demo.code.base.BaseActivity
import com.demo.code.databinding.ActivityJobsBinding

class JobsActivity : BaseActivity() {

    private lateinit var binding: ActivityJobsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityJobsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        hideUpButton()
        setOnClickListeners()
    }

    private fun setOnClickListeners() {
        binding.apply {
            launchId.setOnClickListener {

            }
        }
    }

    override fun getToolbarTitle() = "Jobs in Coroutine"

}