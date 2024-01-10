package com.istudio.app.utils.endpoints

import com.istudio.app.utils.log.ThreadInfoLogger
import kotlin.random.Random

class GetReputationEndpoint {
    fun getReputation(userId: String): Int {
        ThreadInfoLogger.logThreadInfo("GetReputationEndpoint#getReputation(): called")
        Thread.sleep(3000)
        ThreadInfoLogger.logThreadInfo("GetReputationEndpoint#getReputation(): return data")
        return Random.nextInt(0, 100)
    }
}