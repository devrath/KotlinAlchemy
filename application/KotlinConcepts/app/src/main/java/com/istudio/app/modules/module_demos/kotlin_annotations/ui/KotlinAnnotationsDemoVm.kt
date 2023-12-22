package com.istudio.app.modules.module_demos.kotlin_annotations.ui

import androidx.lifecycle.ViewModel
import com.istudio.app.modules.module_demos.kotlin_annotations.utils.jvmField.init.JavaInstanceJf
import com.istudio.app.modules.module_demos.kotlin_annotations.utils.jvmField.init.KotlinInstanceJf
import com.istudio.app.modules.module_demos.kotlin_annotations.utils.jvmOverloads.init.JavaInstanceJo
import com.istudio.app.modules.module_demos.kotlin_annotations.utils.jvmOverloads.init.KotlinInstanceJo
import com.istudio.app.modules.module_demos.kotlin_annotations.utils.jvmstatic.init.JavaInstanceJs
import com.istudio.app.modules.module_demos.kotlin_annotations.utils.jvmstatic.init.KotlinInstanceJs
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
        JavaInstanceJo().initilize()
        // Creating instance in KOTLIN
        KotlinInstanceJo().initilize()
    }

    fun jvmStaticDemo() {
        // Creating instance in JAVA
        JavaInstanceJs().initilize()
        // Creating instance in KOTLIN
        KotlinInstanceJs().initilize()
    }

    fun stringResDemo() {

    }


}