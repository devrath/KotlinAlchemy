package com.istudio.app.modules.module_demos.coroutines.launch_and_withcontext

import androidx.lifecycle.ViewModel
import com.istudio.app.utils.extensions.printCoroutineScopeInfo
import kotlinx.coroutines.CoroutineName
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.cancel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.util.concurrent.CancellationException
import javax.inject.Inject

class LaunchAndWithContextDemoVm @Inject constructor( ) : ViewModel() {

    // Create a root co-routine scope
    private val rootScope =  CoroutineScope(
        Dispatchers.Main + CoroutineName("Root-Coroutine")
    )

    private val childScope =  CoroutineScope(
        Dispatchers.Main + CoroutineName("Child-Coroutine")
    )

    fun demo() = rootScope.launch {
        printCoroutineScopeInfo()
        childScope.launch {
            printCoroutineScopeInfo()
            withContext(Dispatchers.Main + CoroutineName("Child-nested-Coroutine")){
                printCoroutineScopeInfo()
            }
        }
    }

}