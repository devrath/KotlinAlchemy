package com.demo.code.usecases.coroutines.usecase12

import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import com.demo.code.R
import com.demo.code.base.BaseActivity
import com.demo.code.base.useCase12Description
import com.demo.code.databinding.ActivityCalculationinmultiplebackgroundthreadsBinding
import com.demo.code.utils.hideKeyboard
import com.demo.code.utils.setGone
import com.demo.code.utils.setVisible
import com.demo.code.utils.toast

class CalculationInSeveralCoroutinesActivity : BaseActivity() {

    override fun getToolbarTitle() = useCase12Description

    private val binding by lazy {
        ActivityCalculationinmultiplebackgroundthreadsBinding.inflate(
            layoutInflater
        )
    }

    private val viewModel: CalculationInSeveralCoroutinesViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        viewModel.uiState()
            .observe(this, Observer { uiState ->
            if (uiState != null) {
                render(uiState)
            }
        })
        binding.btnCalculate.setOnClickListener {
            val factorialOf = binding.editTextFactorialOf.text.toString().toIntOrNull()
            val numberOfThreads = binding.editTextNumberOfThreads.text.toString().toIntOrNull()
            if (factorialOf != null && numberOfThreads != null) {
                viewModel.performCalculation(
                    factorialOf,
                    numberOfThreads
                )
            }
        }
    }

    private fun render(uiState: UiState) {
        when (uiState) {
            is UiState.Loading -> {
                onLoad()
            }
            is UiState.Success -> {
                onSuccess(uiState)
            }
            is UiState.Error -> {
                onError(uiState)
            }
        }
    }

    private fun onLoad() = with(binding) {
        progressBar.setVisible()
        textViewResult.text = ""
        textViewDuration.text = ""
        textViewStringConversionDuration.text = ""
        btnCalculate.isEnabled = false
        textViewResult.hideKeyboard()
    }

    private fun onSuccess(uiState: UiState.Success) = with(binding) {
        textViewDuration.text =
            getString(R.string.duration_calculation, uiState.computationDuration)
        textViewStringConversionDuration.text =
            getString(R.string.duration_stringconversion, uiState.stringConversionDuration)
        progressBar.setGone()
        btnCalculate.isEnabled = true
        textViewResult.text = if (uiState.result.length <= 150) {
            uiState.result
        } else {
            "${uiState.result.substring(0, 147)}..."
        }
    }

    private fun onError(uiState: UiState.Error) = with(binding) {
        progressBar.setGone()
        btnCalculate.isEnabled = true
        toast(uiState.message)
    }
}