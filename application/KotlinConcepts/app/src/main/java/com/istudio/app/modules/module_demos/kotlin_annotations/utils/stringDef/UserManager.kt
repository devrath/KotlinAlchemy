package com.istudio.app.modules.module_demos.kotlin_annotations.utils.stringDef

import android.util.Log

class UserManager {

    fun modifyUserStatus(@UserStatus.Status status: String) {
        when(status){
            UserStatus.ACTIVE -> {
                Log.d("UserStatus","Logically Active")
            }
            UserStatus.IN_ACTIVE -> {
                Log.d("UserStatus","Logically InActive")
            }
            UserStatus.BANNED -> {
                Log.d("UserStatus","Logically Banned")
            }
        }
    }

}