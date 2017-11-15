package com.wannar.base_library.annotation;

import android.support.annotation.IntDef;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Created by luyunfeng on 16/12/1.
 */
@Retention(RetentionPolicy.SOURCE)
@IntDef({Direction.LEFT, Direction.TOP, Direction.RIGHT, Direction.BOTTOM})
public @interface Direction {
    public int LEFT = 1;
    public int TOP = 2;
    public int RIGHT = 3;
    public int BOTTOM = 4;
}
