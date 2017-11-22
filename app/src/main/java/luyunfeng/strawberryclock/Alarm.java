package luyunfeng.strawberryclock;

/**
 * Created by luyunfeng on 17/11/15.
 */

public class Alarm {
    public int id;
    public int hour;
    public int minute;
    public String note;
    public boolean vibrate;
    public boolean sound;
    public boolean[] repeatDays = new boolean[7];

    public void cancelEveryDay() {
        for (int i = 0; i < repeatDays.length; i++) {
            repeatDays[i] = false;
        }
    }

    public void cancelWeekDays() {
        for (int i = 0; i < 5; i++) {
            repeatDays[i] = false;
        }
    }

    public void cancelWeekend() {
        for (int i = 5; i < repeatDays.length; i++) {
            repeatDays[i] = false;
        }
    }

    public void repeatEveryday() {
        for (int i = 0; i < repeatDays.length; i++) {
            repeatDays[i] = true;
        }
    }

    public void repeatWeekend() {
        cancelWeekDays();
        for (int i = 5; i < repeatDays.length; i++) {
            repeatDays[i] = true;
        }
    }

    public void repeatWeekDays() {
        for (int i = 0; i < 5; i++) {
            repeatDays[i] = true;
        }
        cancelWeekend();
    }
}
