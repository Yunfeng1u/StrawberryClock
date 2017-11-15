package com.wannar.base_library.view;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.view.View;

/**
 * Created by luyunfeng on 17/8/28.
 * 基础实用类 - 处理View相关操作
 */

public class ViewUtils {
    /**
     * 获取View所属的Activity，处理View初始化时Activity可能被Wrap
     */
    public static Activity getActivityFromView(View view) {
        if (view != null) {
            Context context = view.getContext();
            while (context instanceof ContextWrapper) {
                if (context instanceof Activity) {
                    return (Activity) context;
                }
                context = ((ContextWrapper) context).getBaseContext();
            }
        }
        return null;
    }
}
