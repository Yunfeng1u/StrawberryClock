package luyunfeng.strawberryclock.utils;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Created by luyunfeng on 17/4/20.
 */

public class ThreadHelper {
    public static Future submit(Runnable runnable) {
        ExecutorService service = Executors.newSingleThreadExecutor();
        return service.submit(runnable);
    }

}
