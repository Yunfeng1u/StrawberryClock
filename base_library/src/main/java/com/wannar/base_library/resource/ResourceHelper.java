package com.wannar.base_library.resource;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.annotation.ArrayRes;
import android.support.annotation.ColorRes;
import android.support.annotation.DimenRes;
import android.support.annotation.DrawableRes;
import android.support.annotation.PluralsRes;
import android.support.annotation.StringRes;
import android.text.TextUtils;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by luyunfeng on 17/8/21.
 */

public class ResourceHelper {

    @SuppressLint("StaticFieldLeak")
    private static Context context;

    private static Resources resources;

    public static void init(Context context) {
        ResourceHelper.context = context;
        resources = context.getResources();
    }

    public static Resources getResources() {
        return resources;
    }

    public static Resources.Theme getTheme(){
        return context.getTheme();
    }

    public static float getDimension(@DimenRes int dimenId) {
        if (dimenId <= 0) return 0;
        return resources.getDimension(dimenId);
    }

    public static int getDimensionPixelSize(@DimenRes int dimenId) {
        if (dimenId <= 0) return 0;
        return resources.getDimensionPixelSize(dimenId);
    }

    public static float getSpPixelSize(@DimenRes int dimenId) {
        return getDimension(dimenId) / resources.getDisplayMetrics().scaledDensity;
    }

    public static String getString(@StringRes int stringId) {
        if (stringId <= 0) return "";
        return resources.getString(stringId);
    }

    public static String[] getStringArray(@ArrayRes int resId) {
        return resources.getStringArray(resId);
    }

    public static String getQuantityString(@PluralsRes int resId, int count) {
        return resources.getQuantityString(resId, count);
    }

    public static String getQuantityString(@PluralsRes int resId, int count, Object... args) {
        return resources.getQuantityString(resId, count, args);
    }

    public static int getColor(@ColorRes int resId) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            return resources.getColor(resId, context.getTheme());
        } else {
            return resources.getColor(resId);
        }
    }

    public static ColorStateList getColorStateList(@ColorRes int resId) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            return resources.getColorStateList(resId, context.getTheme());
        } else {
            return resources.getColorStateList(resId);
        }
    }

    public static Drawable getDrawable(@DrawableRes int resId) {
        if (resId <= 0) return null;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            return resources.getDrawable(resId, context.getTheme());
        } else {
            return resources.getDrawable(resId);
        }
    }

    public static InputStream openAsset(String file) {
        try {
            return resources.getAssets().open(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static int getStringId(String name) {
        return getIdentifier(name, "string");
    }

    public static int getDrawableId(String name) {
        return getIdentifier(name, "drawable");
    }

    public static int getId(String name) {
        return getIdentifier(name, "id");
    }

    public static int getIdentifier(String name, @IdentifierType String type) {
        return getIdentifier(name, type, 0);
    }

    public static int getIdentifier(String name, @IdentifierType String type, int fallback) {
        if (TextUtils.isEmpty(name)) {
            return fallback;
        }
        int id = resources.getIdentifier(name, type, context.getPackageName());
        if (id <= 0) {
            return fallback;
        }
        return id;
    }

}
