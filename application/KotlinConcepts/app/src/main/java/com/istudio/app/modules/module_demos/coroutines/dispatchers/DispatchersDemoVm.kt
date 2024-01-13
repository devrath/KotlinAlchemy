package com.istudio.app.modules.module_demos.coroutines.dispatchers

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.cancel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import java.util.concurrent.CancellationException
import javax.inject.Inject

class DispatchersDemoVm @Inject constructor( ) : ViewModel() {

    // Create a root co-routine scope
    private val rootScope =  CoroutineScope(Dispatchers.Default)


    fun demo() {

    }

}