package com.istudio.code.jvmField

import com.istudio.code.utils.PrintUtils

class DemoKotlinJvmAnnotation {

    fun initiate() {
        val person = Person("Suresh", 23)
        PrintUtils.printLog(person.name)
        PrintUtils.printLog(person.age.toString())
    }

}