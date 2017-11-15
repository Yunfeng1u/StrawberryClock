package com.wannar.wannar_adroid2.util.kotlin_extentions

import android.os.Parcelable
import android.support.v4.app.Fragment

/**
 * 帮助验证必要和快捷获取参数
 */
fun Fragment.getString(key: String): String {
    return if (arguments == null) {
        ""
    } else {
        arguments.getString(key, "")
    }
}

fun Fragment.getInt(key: String): Int {
    return if (arguments == null) {
        0
    } else {
        arguments.getInt(key)
    }
}

fun Fragment.getFloat(key: String): Float {
    return if (arguments == null) {
        0f
    } else {
        arguments.getFloat(key)
    }
}

fun Fragment.getBoolean(key: String): Boolean {
    return if (arguments == null) {
        false
    } else {
        arguments.getBoolean(key)
    }
}

fun Fragment.getLong(key: String): Long {
    return if (arguments == null) {
        0
    } else {
        arguments.getLong(key)
    }
}

fun <T : Parcelable> Fragment.getList(key: String) = arguments?.getParcelableArrayList<T>(key)

fun Fragment.getStringList(key: String) = arguments?.getStringArrayList(key)

fun Fragment.getIntList(key: String) = arguments?.getIntegerArrayList(key)

