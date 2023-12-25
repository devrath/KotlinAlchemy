package com.istudio.app.modules.module_demos.flows.modules.flow_basics.chapters.intermediate_operators

import android.content.Context
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

@HiltViewModel
class IntermediateOperatorsVm @Inject constructor(
    @ApplicationContext private val context: Context,
) : ViewModel() {

}