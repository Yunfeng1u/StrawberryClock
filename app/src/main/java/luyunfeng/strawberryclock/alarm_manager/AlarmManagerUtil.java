package luyunfeng.strawberryclock.alarm_manager;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;

import com.wannar.base_library.tips.Toast;

import java.util.Calendar;

import luyunfeng.strawberryclock.Alarm;
import luyunfeng.strawberryclock.BuildConfig;
import luyunfeng.strawberryclock.global.Constant;
import luyunfeng.strawberryclock.utils.DeviceUtils;

/**
 * Created by loonggg on 2016/3/21.
 */
public class AlarmManagerUtil {

    public static final String ALARM_ACTION = BuildConfig.APPLICATION_ID + ".alarm";

    public static void setAlarmTime(Context context, long timeInMillis, Intent intent) {
        AlarmManager am = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);
        PendingIntent sender = PendingIntent.getBroadcast(context, intent.getIntExtra("id", 0),
                intent, PendingIntent.FLAG_CANCEL_CURRENT);
        int interval = (int) intent.getLongExtra("intervalMillis", 0);
        am.setWindow(AlarmManager.RTC_WAKEUP, timeInMillis, interval, sender);
    }

    public static void cancelAlarm(Context context, String action, int id) {
        Intent intent = new Intent(action);
        PendingIntent pi = PendingIntent.getBroadcast(context, id, intent, PendingIntent
                .FLAG_CANCEL_CURRENT);
        AlarmManager am = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);
        am.cancel(pi);
    }


    public static void setAlarm(Context context, Alarm alarm) {
        int soundOrVibrator;
        if (alarm.sound && alarm.vibrate) {
            soundOrVibrator = 2;
        } else if (alarm.sound) {
            soundOrVibrator = 1;
        } else {
            soundOrVibrator = 0;
        }
        setAlarm(context, alarm.id, alarm.hour, alarm.minute, 0, alarm.repeatDays, alarm.note, soundOrVibrator);
    }

    public static void setAlarm(Context context, int id, int hour, int minute, long intervalMillis,
                                boolean[] repeatDays, String tips, int soundOrVibrator) {

        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY, hour);
        calendar.set(Calendar.MINUTE, minute);
        calendar.add(Calendar.SECOND, 10);

        Intent intent = new Intent(ALARM_ACTION);
        intent.putExtra("intervalMillis", intervalMillis);
        intent.putExtra("msg", tips);
        intent.putExtra("id", id);
        intent.putExtra("soundOrVibrator", soundOrVibrator);
        PendingIntent sender = PendingIntent.getBroadcast(context, id, intent, PendingIntent.FLAG_CANCEL_CURRENT);

        long startTime = getStartTime(repeatDays, calendar.getTimeInMillis());

        AlarmManager am = DeviceUtils.getSystemService(Context.ALARM_SERVICE);
        am.setWindow(AlarmManager.RTC_WAKEUP, startTime, intervalMillis, sender);

        Toast.info(getFormatGapTime(startTime));

    }

    private static long getStartTime(boolean[] repeatDays, long dateTime) {
        if (isNotRepeat(repeatDays)) {
            if (dateTime > System.currentTimeMillis()) {
                return dateTime;
            } else {
                return dateTime + Constant.ONE_DAY;
            }
        } else {

            int todayWeek = Calendar.getInstance().get(Calendar.DAY_OF_WEEK);
            if (todayWeek == Calendar.SUNDAY) {
                todayWeek = 6;
            } else {
                todayWeek = todayWeek - 2;
            }

            int firstRepeatDay = 0;
            for (int i = 0; i < repeatDays.length; i++) {
                if (repeatDays[i]) {
                    firstRepeatDay = i;
                }
            }

            if (firstRepeatDay == todayWeek) {
                if (dateTime > System.currentTimeMillis()) {
                    return dateTime;
                } else {
                    return dateTime + Constant.ONE_WEEK;
                }
            } else if (firstRepeatDay > todayWeek) {
                return dateTime + (firstRepeatDay - todayWeek) * Constant.ONE_DAY;
            } else {
                return dateTime + (firstRepeatDay - todayWeek + 7) * Constant.ONE_DAY;
            }
        }
    }


    private static String getFormatGapTime(long startTime) {
        long timeGap = startTime - System.currentTimeMillis();
        int days = (int) (timeGap / Constant.ONE_DAY);
        int remainder = (int) (timeGap % Constant.ONE_DAY);
        int hours = (int) (remainder / Constant.ONE_HOUR);
        remainder = (int) (remainder % Constant.ONE_HOUR);
        int min = (int) (remainder / Constant.ONE_MINUTE);

        String time;

        if (days > 0) {
            time = days + "天" + hours + "小时" + min + "分钟";
        } else if (hours > 0) {
            time = hours + "小时" + min + "分钟";
        } else {
            time = min + "分钟";
        }

        return "闹钟将于" + time + "后启动";
    }

    public static boolean isNotRepeat(boolean[] repeatDays) {
        return !repeatDays[0]
                && !repeatDays[1]
                && !repeatDays[2]
                && !repeatDays[3]
                && !repeatDays[4]
                && !repeatDays[5]
                && !repeatDays[6];
    }

    public static boolean isEveryDay(boolean[] repeatDays) {
        return repeatDays[0]
                && repeatDays[1]
                && repeatDays[2]
                && repeatDays[3]
                && repeatDays[4]
                && repeatDays[5]
                && repeatDays[6];
    }

    public static boolean isWeekday(boolean[] repeatDays) {
        return repeatDays[0]
                && repeatDays[1]
                && repeatDays[2]
                && repeatDays[3]
                && repeatDays[4]
                && !repeatDays[5]
                && !repeatDays[6];
    }

    public static boolean isWeekend(boolean[] repeatDays) {
        return !repeatDays[0]
                && !repeatDays[1]
                && !repeatDays[2]
                && !repeatDays[3]
                && !repeatDays[4]
                && repeatDays[5]
                && repeatDays[6];
    }
}
