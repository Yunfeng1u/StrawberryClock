package com.wannar.base_library.math;

/**
 * Created by luyunfeng on 17/9/30.
 */

public class IntegerUtils {
    public static int compare(int x, int y) {
        return (x < y) ? -1 : ((x == y) ? 0 : 1);
    }
}
