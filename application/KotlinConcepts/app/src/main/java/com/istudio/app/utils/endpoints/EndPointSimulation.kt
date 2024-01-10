package com.istudio.app.utils.endpoints

import com.istudio.app.utils.log.ThreadInfoLogger
import kotlin.random.Random

object EndPointSimulation {
    fun endPointCall(userId: String): Int {
        ThreadInfoLogger.logThreadInfo("EndPointSimulation#endPointCall(): called")
        Thread.sleep(10000)
        ThreadInfoLogger.logThreadInfo("EndPointSimulation#endPointCall(): return data")
        return Random.nextInt(0, 100)
    }
}