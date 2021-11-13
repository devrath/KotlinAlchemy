package com.demo.code.activities

import android.os.Bundle
import com.demo.code.base.BaseActivity
import com.demo.code.databinding.ActivityObservableTypesBinding

class ObservableTypesActivity  : BaseActivity() {

    override fun getToolbarTitle() = "Observable Types"

    private lateinit var binding: ActivityObservableTypesBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityObservableTypesBinding.inflate(layoutInflater)
        setContentView(binding.root)
        hideUpButton()
        setOnClickListeners()
    }

    private fun setOnClickListeners() {
        binding.apply {
            liveDataId.setOnClickListener {
                liveDataDemo()
            }

            stateFlowId.setOnClickListener {
                stateFlowDemo()
            }

            flowId.setOnClickListener {
                flowDemo()
            }

            sharedFlowId.setOnClickListener {
                sharedFlowDemo()
            }
        }
    }

    private fun liveDataDemo() {

    }

    private fun stateFlowDemo() {

    }

    private fun flowDemo() {

    }

    private fun sharedFlowDemo() {

    }
}