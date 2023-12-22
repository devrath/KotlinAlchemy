package com.istudio.app.modules.module_demos.kotlin_annotations.utils.jvmstatic

object Cinema {
    fun getActorName(): String{ return "John" }
    @JvmStatic
    fun getActressName(): String{ return "Sarah" }
}