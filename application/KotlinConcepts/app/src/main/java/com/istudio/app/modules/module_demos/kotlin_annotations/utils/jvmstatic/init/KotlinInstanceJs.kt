package com.istudio.app.modules.module_demos.kotlin_annotations.utils.jvmstatic.init

import com.istudio.app.modules.module_demos.kotlin_annotations.utils.jvmstatic.Cinema

class KotlinInstanceJs {

    fun initilize() {
        println(Cinema.getActorName())
        println(Cinema.getActressName())
    }

}