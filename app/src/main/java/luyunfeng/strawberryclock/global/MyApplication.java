package luyunfeng.strawberryclock.global;

import android.annotation.SuppressLint;
import android.app.Application;
import android.content.Context;

import luyunfeng.strawberryclock.utils.AppUtil;

public class MyApplication extends Application {

    @SuppressLint("StaticFieldLeak")
    private static Context context;

    public static Context getContext() {
        return context;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        context = getApplicationContext();
        AppUtil.initApp(this);
    }
}
