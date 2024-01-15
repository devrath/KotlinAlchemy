package com.istudio.app.modules.module_demos.coroutines.launch_and_withcontext

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.cancel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import java.util.concurrent.CancellationException
import javax.inject.Inject

class LaunchAndWithContextDemoVm @Inject constructor( ) : ViewModel() {

    // Create a root co-routine scope
    private val rootScope =  CoroutineScope(Dispatchers.Default)

    fun demo() {

    }


    fun cancel() {
        println("User invokes cancel")
        rootScope.cancel(cause = CancellationException("Cancelled explicitly by user"))
    }


}