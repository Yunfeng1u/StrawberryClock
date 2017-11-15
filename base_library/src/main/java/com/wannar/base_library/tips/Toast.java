package com.wannar.base_library.tips;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.support.annotation.StringRes;

import com.wannar.base_library.resource.ResourceHelper;

import es.dmoral.toasty.Toasty;

/**
 * Created by luyunfeng on 17/8/21.
 * Toast提示信息
 */

public class Toast {

    @SuppressLint("StaticFieldLeak")
    private static Context context;

    public static void init(Context context) {
        Toast.context = context;
        Toasty.Config.getInstance()
                .setSuccessColor(Color.parseColor("#4db695"))
                .setWarningColor(Color.parseColor("#ff8a65"))
                .setInfoColor(Color.parseColor("#707070"))
                .apply();
    }

    public static void info(String text) {
        Toasty.info(context, text, android.widget.Toast.LENGTH_SHORT, false).show();
    }

    public static void info(@StringRes int textId) {
        info(ResourceHelper.getString(textId));
    }


    public static void successL(String text) {
        Toasty.success(context, text, android.widget.Toast.LENGTH_LONG).show();
    }

    public static void successL(@StringRes int textId) {
        successL(ResourceHelper.getString(textId));
    }

    public static void success(String text) {
        Toasty.success(context, text, android.widget.Toast.LENGTH_SHORT).show();
    }

    public static void success(@StringRes int textId) {
        success(ResourceHelper.getString(textId));
    }

    // 只用于严重错误
    public static void error(String text) {
        Toasty.error(context, text).show();
    }

    // 由用户的操作错误引起的警告
    public static void warning(String text) {
        Toasty.warning(context, text).show();
    }

    public static void warning(@StringRes int textId) {
        warning(ResourceHelper.getString(textId));
    }

}
