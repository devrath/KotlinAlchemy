package com.istudio.app.modules.module_demos.kotlin_annotations.utils.jvmField.init

import com.istudio.app.modules.module_demos.kotlin_annotations.utils.jvmField.KotlinPerson

class KotlinInstanceJf {

    fun initilize() {
        val (name, age) = KotlinPerson("Suresh", 21)
        println(name)
        println(age)
    }

}