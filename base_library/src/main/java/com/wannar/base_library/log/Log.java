package com.wannar.base_library.log;

/**
 * Created by luyunfeng on 16/7/20.
 */
public class Log {

    private static boolean isLogEnable = true;

    public static void init(boolean isLogEnable){
        Log.isLogEnable = isLogEnable;
        if (isLogEnable){
            Logger.init("test").setMethodCount(10).hideThreadInfo().setLogLevel(LogLevel.FULL);
        }else{
            Logger.init("test").setMethodCount(1).hideThreadInfo().setLogLevel(LogLevel.NONE);
        }
    }

    public static void d(String text1, Object text2) {
        if (isLogEnable) {
            d(String.format("%s = %s", text1, text2.toString()));
        }
    }

    public static void d(Object obj) {
        if (isLogEnable && obj != null) {
            Logger.d(obj.toString());
        }
    }

    public static void d(String info) {
        if (isLogEnable && info != null) {
            Logger.d(info);
        }
    }

    public static void e(String info) {
        if (isLogEnable && info != null) {
            Logger.e(info);
        }
    }

    public static void b(String text) {
        if (isLogEnable) {
            android.util.Log.d("test", text);
        }
    }

    public static void printStackTrace(Throwable e) {
        if (isLogEnable) {
            e.printStackTrace();
        }
    }
}
