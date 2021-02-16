package com.demo.code.usecases.flow.usecase1

import android.os.Bundle
import com.demo.code.base.BaseActivity
import com.demo.code.databinding.ActivityFlowUsecase1Binding

class FlowUseCase1Activity : BaseActivity() {

    private val binding by lazy { ActivityFlowUsecase1Binding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
    }

    override fun getToolbarTitle() = "Flow Use Case 1 Activity"

}