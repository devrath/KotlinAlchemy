package com.istudio.app.utils.extensions

import android.content.Context
import android.content.Intent
import android.os.Bundle


/** ************************* Launching activity ************************* **/

/** SAMPLE ->
openActivity(MyActivity::class.java) {
putString("string.key", "string.value")
putInt("string.key", 43)
...
}
 */
fun <T> Context.openActivity(it: Class<T>, extras: Bundle.() -> Unit = {}) {
    val intent = Intent(this, it)
    intent.putExtras(Bundle().apply(extras))
    startActivity(intent)
}
/** ************************* Launching activity ************************* **/