package com.wannar.wannar_adroid2.util.kotlin_extentions

import android.content.Context
import android.view.MotionEvent
import luyunfeng.strawberryclock.BaseActivity
import luyunfeng.strawberryclock.global.MyApplication
import luyunfeng.strawberryclock.utils.MotionUtil

/**
 * Created by luyunfeng on 17/8/16.
 */

fun getAppContext(): Context = MyApplication.getContext()

fun BaseActivity.touchEventHandler(ev: MotionEvent): Boolean? {
    when (ev.action) {
        MotionEvent.ACTION_DOWN ->
            return if (System.currentTimeMillis() - lastValidDownTime > 280) {
                lastValidDownTime = System.currentTimeMillis()
                // 点击EditText以外的地方，键盘隐藏
                val v = currentFocus
                if (MotionUtil.shouldHideKeyBoard(v, ev)) {
                    MotionUtil.hideKeyBoard(v)
                }
                null
            } else {
                false
            }
        MotionEvent.ACTION_MOVE -> {
        }
        MotionEvent.ACTION_UP ->
            return if (System.currentTimeMillis() - lastValidUpTime > 280) {
                lastValidUpTime = System.currentTimeMillis()
                try {
                    window.superDispatchTouchEvent(ev) || onTouchEvent(ev)
                } catch (e: Exception) {
                    false
                }
            } else {
                false
            }
    }
    return try {
        window.superDispatchTouchEvent(ev) || onTouchEvent(ev)
    } catch (e: Exception) {
        false
    }
}
