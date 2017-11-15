package com.wannar.wannar_adroid2.util.kotlin_extentions

import android.app.Activity
import android.app.Dialog
import android.support.annotation.LayoutRes
import android.support.annotation.StringRes
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.text.Spanned
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.ViewStub
import android.widget.TextView
import luyunfeng.strawberryclock.utils.ViewHelper

/**
 * Created by luyunfeng on 17/5/23.
 * View的帮助扩展函数，一般为了简化用法。
 * 复杂方法请移至静态工具类。
 */

/**
 * 设置点击回调
 */
fun View?.setClickCallback(listener: View.OnClickListener?) {
    this?.setOnClickListener(listener)
}

fun View.OnClickListener.setClickCallback(view: View?) {
    view?.setOnClickListener(this)
}

fun View.OnClickListener.setClickCallback(vararg views: View?) {
    views.forEach {
        it.setClickCallback(this)
    }
}


/**
 * 设置文字
 */
fun TextView?.text(source: String?) {
    this ?: return
    if (source == null) {
        this.text = ""
    } else {
        this.text = source
    }
}

fun TextView?.text(source: Spanned?) {
    this ?: return
    if (source == null) {
        this.text = ""
    } else {
        this.text = source
    }

}

fun TextView?.text(@StringRes resId: Int) {
    this ?: return
    if (resId == 0) {
        this.text = ""
    } else {
        this.setText(resId)
    }
}

fun TextView?.setNotNullText(source: String?) {
    if (source.isNullOrEmpty()) {
        GONE()
    }else{
        text(source)
        VISIBLE()
    }
}

fun TextView?.setNotNullText(source: Spanned?) {
    if (source.isNullOrEmpty()) {
        GONE()
    }else{
        text(source)
        VISIBLE()
    }
}

/**
 * 设置View可见性
 */
fun View?.visibility(visibility: Int) {
    this ?: return
    if (this.visibility != visibility) {
        this.visibility = visibility
    }
}

fun View?.GONE() {
    this.visibility(View.GONE)
}

fun View?.VISIBLE() {
    this.visibility(View.VISIBLE)
}

fun View?.INVISIBLE() {
    this.visibility(View.INVISIBLE)
}

/**
 * 移除所有子布局
 */
fun ViewGroup?.removeChildren() {
    this ?: return
    if (childCount > 0) {
        removeAllViews()
    }
}


/**
 * 加载布局
 */
fun ViewGroup.inflateView(@LayoutRes layoutId: Int): View =
        LayoutInflater.from(context).inflate(layoutId, this, false)

fun Activity.inflateView(@LayoutRes layoutId: Int): View {
    val view = LayoutInflater.from(this).inflate(layoutId, null)
    val root = this.findViewById<ViewGroup>(android.R.id.content)
    root.addView(view)
    return view
}


/**
 * 加载ViewStub
 */
fun ViewStub?.inflateViewStub() : View? {
    this ?: return null
    if (parent != null) {
        return inflate()
    }
    return null
}

/**
 * 隐藏对话框
 */
fun Dialog?.dialogDismiss() {
    this ?: return
    if (isShowing) {
        dismiss()
    }
}

/**
 * 显示对话框
 */
fun Dialog?.dialogShow() {
    this ?: return
    if (!isShowing) {
        show()
    }
}

fun RecyclerView?.init() {
    this ?: return
    this.setHasFixedSize(true)
    this.layoutManager = LinearLayoutManager(getAppContext())
}

fun RecyclerView?.initWithDivider() {
    this ?: return
    init()
    if (this.tag == null || this.tag != "divider_added") {
        val itemDecoration = ViewHelper.getDivider()
        this.addItemDecoration(itemDecoration)
        this.tag = "divider_added"
    }
}

fun TextView?.getString(): String {
    this ?: return ""
    return this.text.toString()
}
