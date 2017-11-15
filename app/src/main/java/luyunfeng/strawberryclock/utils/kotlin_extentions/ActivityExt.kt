package com.wannar.wannar_adroid2.util.kotlin_extentions

import android.app.Activity
import android.content.Intent
import android.os.Bundle

/**
 * Created by luyunfeng on 17/6/27.
 * Activity扩展函数
 */


/**
 * 防止界面快速关闭时，还有数据消息队列发送消息
 */
fun Activity?.isAlive(): Boolean {
    this ?: return false
    if (this.isDestroyed || this.isFinishing)
        return false
    return true
}


/**
 * Activity跳转
 */
fun Activity.openActivity(cls: Class<*>, bundle: Bundle? = null) {
    val intent = Intent()
    intent.setClass(this, cls)
    if (bundle != null) {
        intent.putExtras(bundle)
    }
    startActivity(intent)
}

fun Activity.openActivity4Result(cls: Class<*>, requestCode: Int, bundle: Bundle? = null) {
    val intent = Intent()
    intent.setClass(this, cls)
    if (bundle != null) {
        intent.putExtras(bundle)
    }
    startActivityForResult(intent, requestCode)
}


