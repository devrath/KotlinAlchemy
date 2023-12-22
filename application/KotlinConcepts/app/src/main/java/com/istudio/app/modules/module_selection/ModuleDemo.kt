package com.istudio.app.modules.module_selection
sealed class ModuleDemo(val rout: String) {
    data object ChannelsDemo : ModuleDemo("ChannelsDemo")
    data object DemoSelection : ModuleDemo("DemoSelection")
    data object SealedClassDemo : ModuleDemo("SealedClassDemo")
    data object HigherOrderFunctions : ModuleDemo("HigherOrderFunctions")
}