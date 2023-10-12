package com.istudio.code.modules.jvmStatic

object KotlinUtils {
    fun getActorName(): String{ return "John" }
    @JvmStatic
    fun getActressName(): String{ return "Sarah" }
}