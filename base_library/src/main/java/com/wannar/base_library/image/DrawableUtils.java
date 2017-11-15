package com.wannar.base_library.image;

import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.support.annotation.ColorInt;
import android.support.annotation.ColorRes;
import android.support.annotation.DrawableRes;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.widget.TextView;

import com.wannar.base_library.resource.ResourceHelper;
import com.wannar.base_library.annotation.Direction;

/**
 * Drawable工具类
 *
 * @author LuYunfeng
 * @date 2015/9/17
 */
public class DrawableUtils {

    public static void setCompoundDrawableTop(int dimenId, Drawable drawable, TextView button) {
        setCompoundDrawable(Direction.TOP, dimenId, drawable, button);
    }

    public static void setCompoundDrawableLeft(int dimenId, int drawableId, TextView button) {
        Drawable drawable = ResourceHelper.getDrawable(drawableId);
        setCompoundDrawableLeft(dimenId, drawable, button);
    }

    public static void setCompoundDrawableLeft(int dimenId, Drawable drawable, TextView button) {
        setCompoundDrawable(Direction.LEFT, dimenId, drawable, button);
    }

    public static void setCompoundDrawableRight(int dimenId, Drawable drawable, TextView button) {
        setCompoundDrawable(Direction.RIGHT, dimenId, drawable, button);
    }

    public static void setCompoundDrawable(@Direction int direction, int dimenId, Drawable drawable, TextView button) {
        int dimen = (int) ResourceHelper.getDimension(dimenId);
        drawable.setBounds(0, 0, dimen, getConstrainHeight(drawable, dimen));
        switch (direction) {
            case Direction.LEFT:
                button.setCompoundDrawables(drawable, null, null, null);
                break;
            case Direction.TOP:
                button.setCompoundDrawables(null, drawable, null, null);
                break;
            case Direction.RIGHT:
                button.setCompoundDrawables(null, null, drawable, null);
                break;
            case Direction.BOTTOM:
                button.setCompoundDrawables(null, null, null, drawable);
                break;
        }
    }

    /**
     * 根据图标宽度和比例获取高度
     */
    public static int getConstrainHeight(Drawable drawable, int imageWidth) {
        if (imageWidth == 0 || drawable.getIntrinsicWidth() == 0) {
            return 0;
        }
        return (int) (drawable.getIntrinsicHeight() * 1f / drawable.getIntrinsicWidth() * imageWidth);
    }


    /**
     * 着色图标（单色）
     */
    public static Drawable tint(Drawable drawable, @ColorInt int tint) {
        final Drawable wrappedDrawable = DrawableCompat.wrap(drawable.mutate());
        DrawableCompat.setTint(wrappedDrawable, tint);
        return wrappedDrawable;
    }

    /**
     * 着色图标（选择器）
     */
    private static Drawable tintSelector(Drawable drawable, ColorStateList colors) {
        final Drawable wrappedDrawable = DrawableCompat.wrap(drawable.mutate());
        DrawableCompat.setTintList(wrappedDrawable, colors);
        return wrappedDrawable;
    }

    public static Drawable tintSelector(Drawable drawable, @ColorRes int color) {
        ColorStateList colorList = ResourceHelper.getColorStateList(color);
        return tintSelector(drawable, colorList);
    }

    public static Drawable tintSelector(@DrawableRes int drawableId, @ColorRes int color) {
        Drawable drawable = ResourceHelper.getDrawable(drawableId);
        return tintSelector(drawable, color);
    }

}
