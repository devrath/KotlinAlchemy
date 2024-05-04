package com.istudio.app.modules.module_demos.flows.modules.collect_as_state_with_lifecycle

import android.content.Context
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import javax.inject.Inject

@HiltViewModel
class CollectAsStateWithLifeCycleVm @Inject constructor(
    @ApplicationContext private val context: Context,
) : ViewModel() {

    private val _data = MutableSharedFlow<Int>(0)
    val data = _data.asSharedFlow()

    suspend fun produce(value : Int) {
        println("Emitted value -> $value")
        _data.emit(value)
    }

}