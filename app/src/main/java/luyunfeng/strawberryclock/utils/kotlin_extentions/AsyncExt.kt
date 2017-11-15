package com.wannar.wannar_adroid2.util.kotlin_extentions

import android.os.Handler
import android.os.Looper
import android.os.Message
import java.util.concurrent.Executors

/**
 * Created by luyunfeng on 17/8/16.
 */

inline fun postDelay(delay: Long, crossinline block: () -> Unit) {
    Handler().postDelayed(
            {
                block()
            }
            , delay)
}

inline fun runInLooper(crossinline block: () -> Unit) {
    Executors.newSingleThreadExecutor().submit {
        Looper.prepare()
        block()
        Looper.loop()
    }
}

fun Message.match(code : Int) = this.what == code





