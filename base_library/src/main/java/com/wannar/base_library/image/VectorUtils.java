package com.wannar.base_library.image;

import android.graphics.drawable.Drawable;
import android.support.annotation.DrawableRes;
import android.support.graphics.drawable.VectorDrawableCompat;
import android.widget.TextView;

import com.wannar.base_library.resource.ResourceHelper;

/**
 * svg矢量图工具类
 *
 * @author LuYunfeng
 * @date 2015/9/17
 */
public class VectorUtils {

    public static VectorDrawableCompat getDrawable(@DrawableRes int drawableId) {
        return VectorDrawableCompat.create(ResourceHelper.getResources(), drawableId, ResourceHelper.getTheme());
    }

    public static void setCompoundDrawableRight(int dimenId, @DrawableRes int drawableId, TextView button) {
        DrawableUtils.setCompoundDrawableRight(dimenId, getDrawable(drawableId), button);
    }

    public static void setCompoundDrawableLeft(int dimenId, @DrawableRes int drawableId, TextView button) {
        DrawableUtils.setCompoundDrawableLeft(dimenId, getDrawable(drawableId), button);
    }

    public static Drawable tint(@DrawableRes int drawableId, int color) {

        Drawable drawable = getDrawable(drawableId);

        return DrawableUtils.tint(drawable, color);
    }
}
