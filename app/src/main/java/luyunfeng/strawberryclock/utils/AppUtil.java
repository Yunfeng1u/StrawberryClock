package luyunfeng.strawberryclock.utils;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import android.util.DisplayMetrics;

import com.wannar.base_library.log.Log;
import com.wannar.base_library.resource.ResourceHelper;
import com.wannar.base_library.tips.Toast;

import luyunfeng.strawberryclock.BuildConfig;
import luyunfeng.strawberryclock.global.MyApplication;

/**
 * Created by luyunfeng on 17/1/18.
 */

public class AppUtil {

    public static void initApp(Application application) {

//        final Thread.UncaughtExceptionHandler oldHandler = Thread.getDefaultUncaughtExceptionHandler();
//
//        if (oldHandler == null || oldHandler.getClass().getName().startsWith("com.android.internal.os")) {
//            CustomActivityOnCrash.install(application);
//            CustomActivityOnCrash.setErrorActivityClass(ErrorActivity.class);
//            CustomActivityOnCrash.setEventListener(new CrashEventListener());
//        }

        ResourceHelper.init(application);
        Toast.init(MyApplication.getContext());
        boxStore = MyObjectBox.builder().androidContext(application).build();

        //HttpRequestImpl.init();

        application.registerActivityLifecycleCallbacks(new Application.ActivityLifecycleCallbacks() {
            @Override
            public void onActivityCreated(Activity activity, Bundle savedInstanceState) {

            }

            @Override
            public void onActivityStarted(Activity activity) {

            }

            @Override
            public void onActivityResumed(Activity activity) {

            }

            @Override
            public void onActivityPaused(Activity activity) {

            }

            @Override
            public void onActivityStopped(Activity activity) {

            }

            @Override
            public void onActivitySaveInstanceState(Activity activity, Bundle outState) {

            }

            @Override
            public void onActivityDestroyed(Activity activity) {

            }
        });

        initDM();

        lazyInit();
    }


    private static void lazyInit() {
        ThreadHelper.submit(new Runnable() {
            @Override
            public void run() {
                if (isRelease()) {
                    Log.init(false);
                } else {
                    Log.init(true);
                }
            }
        });
    }

    private static void initDM() {
        if (DeviceUtils.mScreenWidth >= DeviceUtils.mScreenHeight) {

            DisplayMetrics displayMetrics = ResourceHelper.getResources().getDisplayMetrics();
            // dip
            DeviceUtils.mDensity = displayMetrics.density;

            // 获取屏幕分辨率宽度
            DeviceUtils.mScreenWidth = displayMetrics.widthPixels;
            DeviceUtils.mScreenHeight = displayMetrics.heightPixels;
        }
    }

    public static boolean isRelease() {
        return "release".equalsIgnoreCase(BuildConfig.BUILD_TYPE);
    }
}