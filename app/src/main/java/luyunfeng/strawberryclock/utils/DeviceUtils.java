package luyunfeng.strawberryclock.utils;

import luyunfeng.strawberryclock.global.MyApplication;

/**
 * Created by luyunfeng on 17/8/22.
 * 设备相关
 */

public class DeviceUtils {
    // 屏幕分辨率
    public static int mScreenWidth;
    // 除去虚拟按键的屏幕高度
    public static int mScreenHeight;
    // dip
    public static float mDensity;

    public static <T> T getSystemService(String name) {
        return (T) MyApplication.getContext().getSystemService(name);
    }

}
