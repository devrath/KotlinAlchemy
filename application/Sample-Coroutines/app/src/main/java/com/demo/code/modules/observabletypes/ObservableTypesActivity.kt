package com.demo.code.modules.observabletypes

import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.lifecycleScope
import com.demo.code.base.BaseActivity
import com.demo.code.databinding.ActivityObservableTypesBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.collectLatest

@AndroidEntryPoint
class ObservableTypesActivity  : BaseActivity() {

    override fun getToolbarTitle() = "Observable Types"

    private lateinit var binding: ActivityObservableTypesBinding
    private val viewModel: ObservableTypesViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityObservableTypesBinding.inflate(layoutInflater)
        setContentView(binding.root)
        hideUpButton()
        setOnClickListeners()
        subscribeData()
    }

    private fun setOnClickListeners() {
        binding.apply {
            liveDataId.setOnClickListener {
                viewModel.liveDataDemo()
            }

            stateFlowId.setOnClickListener {
                viewModel.stateFlowDemo()
            }

            flowId.setOnClickListener {
                flowDemo()
            }

            sharedFlowId.setOnClickListener {
                sharedFlowDemo()
            }
        }
    }

    private fun sharedFlowDemo() {
        viewModel.sharedFlowDemo()
    }

    private fun flowDemo() {
        lifecycleScope.launchWhenStarted {
            viewModel.flowDemo().collectLatest {
                binding.outputTextId.text = it
            }
        }
    }

    private fun subscribeData() {
        viewModel.liveData.observe(this, {
            binding.outputTextId.text = it
        })

        lifecycleScope.launchWhenCreated {
            viewModel.stateFlow.collectLatest {
                binding.outputTextId.text = it
            }
        }

        lifecycleScope.launchWhenStarted {
            viewModel.sharedFlow.collect {
                binding.outputTextId.text = it
            }
        }
    }
}