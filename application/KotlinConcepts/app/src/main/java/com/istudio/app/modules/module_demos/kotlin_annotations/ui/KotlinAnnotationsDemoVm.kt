package com.istudio.app.modules.module_demos.kotlin_annotations.ui

import androidx.lifecycle.ViewModel
import com.istudio.app.modules.module_demos.kotlin_annotations.utils.jvmField.init.JavaInstanceJf
import com.istudio.app.modules.module_demos.kotlin_annotations.utils.jvmField.init.KotlinInstanceJf
import com.istudio.app.modules.module_demos.kotlin_annotations.utils.jvmOverloads.init.JavainstanceJo
import com.istudio.app.modules.module_demos.kotlin_annotations.utils.jvmOverloads.init.KotlinInstanceJo
import javax.inject.Inject

class KotlinAnnotationsDemoVm  @Inject constructor( ) : ViewModel() {

    fun jvmFieldDemo() {
        // Creating instance in JAVA
        JavaInstanceJf().initilize()
        // Creating instance in KOTLIN
        KotlinInstanceJf().initilize()
    }

    fun jvmOverloadsDemo() {
        // Creating instance in JAVA
        JavainstanceJo().initilize()
        // Creating instance in KOTLIN
        KotlinInstanceJo().initilize()
    }

    fun jvmStaticDemo() {

    }

    fun stringResDemo() {

    }


}