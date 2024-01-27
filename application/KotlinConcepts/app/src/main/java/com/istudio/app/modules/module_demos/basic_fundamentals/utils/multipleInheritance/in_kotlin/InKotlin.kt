package com.istudio.app.modules.module_demos.basic_fundamentals.utils.multipleInheritance.in_kotlin

class KotlinImplementation : KotlinInterfaceA, KotlinInterfaceB {

    private val implementationA = ClassA()
    private val implementationB = ClassB()

    override fun methodA() {
        implementationA.methodA()
    }

    override fun methodB() {
        implementationB.methodB()
    }

}

interface KotlinInterfaceA {
    fun methodA()
}

interface KotlinInterfaceB {
    fun methodB()
}

class ClassA : KotlinInterfaceA {
    override fun methodA() {
        println("Implementation of methodA from ClassA")
    }

}

class ClassB : KotlinInterfaceB {
    override fun methodB() {
        println("Implementation of methodB from ClassB")
    }

}