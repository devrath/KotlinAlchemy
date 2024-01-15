package com.istudio.app.modules.module_demos.coroutines.job

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import javax.inject.Inject

class JobDemoSelectionVm @Inject constructor( ) : ViewModel() {

    // Create a root co-routine scope
    private val rootScope =  CoroutineScope(Dispatchers.Default)

    fun demo() {
        // Launch a co-routine within the scope

    }

}