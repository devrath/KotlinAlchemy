package com.istudio.app.modules.module_demos.nested_vs_inner.ui

import androidx.lifecycle.ViewModel
import com.istudio.app.modules.module_demos.nested_vs_inner.utils.OuterClass
import javax.inject.Inject

class NestedVsInnerVm @Inject constructor( ) : ViewModel() {

    fun nestedClassDemo() {
        val innerClassInstance = OuterClass.NestedClass()
        println(innerClassInstance.nestedClassMember)
        println(innerClassInstance.nestedClassFunction())
    }

    fun innerClassDemo() {
        //Constructor of inner class InnerClass can be called only with receiver of containing class
        //val innerClassInstance = OuterClass.InnerClass()

    }

}