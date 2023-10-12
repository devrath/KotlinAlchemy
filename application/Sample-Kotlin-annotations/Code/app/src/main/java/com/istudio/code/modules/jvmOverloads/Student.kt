package com.istudio.code.modules.jvmOverloads

data class Student1(val name: String,val age : Int =  27)
data class Student2 @JvmOverloads constructor(val name: String,val age : Int =  27)
