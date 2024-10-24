package com.istudio.app.modules.module_demos.kotlin_annotations.utils.stringDef

import androidx.annotation.StringDef

object UserStatus {

    const val ACTIVE = "active"
    const val IN_ACTIVE = "inactive"
    const val BANNED = "banned"

    @Retention(AnnotationRetention.SOURCE)
    @StringDef(ACTIVE, IN_ACTIVE, BANNED)
    annotation class Status
}


