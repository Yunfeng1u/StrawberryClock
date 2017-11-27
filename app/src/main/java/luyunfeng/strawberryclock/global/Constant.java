package luyunfeng.strawberryclock.global;


/**
 * 全局常量存放类
 */
public interface Constant {
    String TIME_FORMAT = "%02d:%02d";

    long ONE_MINUTE = 60 * 1000;

    long ONE_HOUR = 60 * ONE_MINUTE;

    long ONE_DAY = 24 * ONE_HOUR;

    long ONE_WEEK = 7 * ONE_DAY;
}
