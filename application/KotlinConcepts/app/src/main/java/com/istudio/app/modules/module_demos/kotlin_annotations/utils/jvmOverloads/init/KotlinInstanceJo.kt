package com.istudio.app.modules.module_demos.kotlin_annotations.utils.jvmOverloads.init

import com.istudio.app.modules.module_demos.kotlin_annotations.utils.jvmOverloads.Student1
import com.istudio.app.modules.module_demos.kotlin_annotations.utils.jvmOverloads.Student2

class KotlinInstanceJo {

    fun initilize() {
        val (name, age) = Student1("Student1", 20)
        val (name1, age1) = Student2("Student1") // Observe we did not pass age, Default value is taken from kotlin class
    }

}