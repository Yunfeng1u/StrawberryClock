package com.wannar.base_library.image;

import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.support.annotation.ColorRes;
import android.widget.ImageView;

import com.wannar.base_library.resource.ResourceHelper;

/**
 * 滤镜工具类，一般用作图片滤镜
 * @author luyunfeng
 * @date 17/10/20
 */

public class ColorFilterUtils {
    public static ColorFilter getColorFilter(@ColorRes int colorRes){
         return new PorterDuffColorFilter(ResourceHelper.getColor(colorRes), PorterDuff.Mode.SRC_ATOP);
    }

    public static void filter(ImageView imageView, @ColorRes int colorRes){
        imageView.setColorFilter(ResourceHelper.getColor(colorRes));
    }
}
