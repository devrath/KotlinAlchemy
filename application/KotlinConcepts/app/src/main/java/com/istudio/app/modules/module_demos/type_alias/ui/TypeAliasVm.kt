package com.istudio.app.modules.module_demos.type_alias.ui

import androidx.lifecycle.ViewModel
import com.istudio.app.modules.module_demos.type_alias.utils.AuthToken
import javax.inject.Inject


class TypeAliasVm @Inject constructor( ) : ViewModel() {

    data class Student(val name : String, val age : Int, val authTolken : AuthToken)
    data class Teacher(val name : String, val age : Int, val authTolken : AuthToken)


    fun demo() {
        val dataOne = Student(name = "Mahesh", age = 20 , authTolken = "282828fhisb")
        val dataTwo = Teacher(name = "Suresh", age = 40 , authTolken = "282828fhisb")

        println(dataOne.authTolken)
        println(dataTwo.authTolken)
    }


}