package com.istudio.app.modules.module_demos.nested_vs_inner.utils

class OuterClass {

    val outerClassMember = "outerClassMember"
    fun outerClassFunction() { }

    class NestedClass {
        val nestedClassMember = "nestedClassMember"
        fun nestedClassFunction() {
            // This is not possible
            // val nestedClassVariable = outerClassMember
            // This is not possible
            // outerClassFunction()
        }
    }

    inner class InnerClass {
        val innerClassMember = "innerClassMember"
        fun innerClassFunction() {
            // This is possible
            val nestedClassVariable = outerClassMember
            // This is possible
            outerClassFunction()
        }
    }

}