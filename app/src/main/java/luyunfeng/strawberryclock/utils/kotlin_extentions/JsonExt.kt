package com.wannar.wannar_adroid2.util.kotlin_extentions

import org.json.JSONArray
import org.json.JSONObject

/**
 * Created by luyunfeng on 17/8/17.
 */

inline fun JSONObject?.iterate(action: (String, JSONObject) -> Unit) {
    if (this == null) return
    val iterator = this.keys()
    while (iterator.hasNext()) {
        val key = iterator.next()
        val value = this.optJSONObject(key)
        action(key, value)
    }
}

inline fun JSONObject?.iterateArray(action: (String, JSONArray) -> Unit) {
    if (this == null) return
    val iterator = this.keys()
    while (iterator.hasNext()) {
        val key = iterator.next()
        val value = this.optJSONArray(key)
        action(key, value)
    }
}

inline fun JSONArray?.iterate(action: (Int, JSONObject) -> Unit) {
    if (this == null) return
    for (i in 0 until this.length()){
        action(i, this.optJSONObject(i))
    }
}
