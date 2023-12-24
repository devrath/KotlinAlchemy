package com.istudio.app.modules.module_selection
sealed class ModuleDemo(val rout: String) {

    data object DemoSelection : ModuleDemo("DemoSelection")
    data object KotlinBasicsDemo : ModuleDemo("KotlinBasicsDemo")
    data object SealedClassDemo : ModuleDemo("SealedClassDemo")
    data object HigherOrderFunctions : ModuleDemo("HigherOrderFunctions")
    data object AnnotationsInKotlin : ModuleDemo("AnnotationsInKotlin")
    data object ChannelsDemo : ModuleDemo("ChannelsDemo")
    data object FlowsSelection : ModuleDemo("FlowsSelection")
    data object FlowBasics : ModuleDemo("FlowBasics")
}