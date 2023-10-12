package com.istudio.code.utils

import android.app.Activity
import android.content.Context
import android.content.Intent

/**
 * Used For: Starting Activity
 * Reference: https://stackoverflow.com/a/57925521/1083093
 */
inline fun <reified T : Activity> Context.startActivity(block: Intent.() -> Unit = {}) {
    startActivity(Intent(this, T::class.java).apply(block))
}