package luyunfeng.strawberryclock.utils;

import android.content.Context;
import android.content.SharedPreferences;

import luyunfeng.strawberryclock.global.MyApplication;

/**
 * Created by LuYunfeng on 2015/10/13.
 * sharePreference
 */
public class SPUtils {

    private static SharedPreferences sharedPreferences = MyApplication.getContext().getSharedPreferences("strawberry_clock", Context.MODE_PRIVATE);

    private static String ALARMS = "ALARMS";

    public static void saveAlarms(String value) {
        putString(ALARMS, value);
    }

    public static String getAlarms() {
        return getString(ALARMS);
    }

    public static void saveCrashContext(String context) {
        putString("crashContext", context);
    }

    public static int getInt(String key) {
        return getInt(key, 0);
    }

    public static int getInt(String key, int fallback) {
        return sharedPreferences.getInt(key, fallback);
    }

    public static String getString(String key, String fallback) {
        return sharedPreferences.getString(key, fallback);
    }

    public static String getString(String key) {
        return getString(key, "");
    }

    public static void putString(String key, String value) {
        sharedPreferences
                .edit()
                .putString(key, value)
                .apply();
    }

    public static void putBoolean(String key, boolean value) {
        sharedPreferences
                .edit()
                .putBoolean(key, value)
                .apply();
    }

    public static boolean getBoolean(String key) {
        return getBoolean(key, false);
    }

    public static boolean getBoolean(String key, boolean fallback) {
        return sharedPreferences.getBoolean(key, fallback);
    }


    public static long getLong(String key) {
        return getLong(key, 0);
    }

    public static long getLong(String key, long fallback) {
        return sharedPreferences.getLong(key, fallback);
    }

    public static SharedPreferences getSharedPreferences() {
        return sharedPreferences;
    }
}
