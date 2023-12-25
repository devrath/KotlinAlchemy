package com.istudio.app.modules.module_demos.flows.modules.flow_basics.state

import com.istudio.app.data.mock.Stock

data class UiState(
    val isLoading: Boolean = false,
    val stockList: List<Stock> = emptyList(),
    val error: UiError = UiError()
)

data class UiError(
    val errorMessage: String = "",
    val isError: Boolean = false
)