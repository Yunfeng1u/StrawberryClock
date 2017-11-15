package com.wannar.wannar_adroid2.util.kotlin_extentions

import com.wannar.base_library.log.Log

/**
 * Created by luyunfeng on 17/10/19.
 */
inline fun safe(crossinline block: () -> Unit) {
    try {
        block()
    } catch (e: Exception) {
        Log.printStackTrace(e)
    }
}