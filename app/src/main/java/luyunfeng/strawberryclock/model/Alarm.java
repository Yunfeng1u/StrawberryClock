package luyunfeng.strawberryclock.model;

import java.util.ArrayList;
import java.util.List;

import io.objectbox.annotation.Entity;
import io.objectbox.annotation.Id;

/**
 * Created by luyunfeng on 17/11/15.
 */

@Entity
public class Alarm {

    @Id
    public long id;

    public int hour;

    public int minute;

    /**
     * 记事/备注
     */
    public String note;

    /**
     * 周期重复
     */
    public List<Boolean> repeatDays = new ArrayList<Boolean>(){
        {
            add(false);
            add(false);
            add(false);
            add(false);
            add(false);
            add(false);
            add(false);
        }
    };



    /**
     * 是否震动提醒
     */
    public boolean vibrate;

    /**
     * 是否震动提醒
     */
    public boolean sound;

    /**
     * 是否启用
     */
    public boolean active = true;

    /**
     * 闹钟模式
     */
    public int mode = 0;

//
//    public void cancelEveryDay() {
//        for (int i = 0; i < repeatDays.length; i++) {
//            repeatDays[i] = false;
//        }
//    }
//
//    public void cancelWeekDays() {
//        for (int i = 0; i < 5; i++) {
//            repeatDays[i] = false;
//        }
//    }
//
//    public void cancelWeekend() {
//        for (int i = 5; i < repeatDays.length; i++) {
//            repeatDays[i] = false;
//        }
//    }
//
//    public void repeatEveryday() {
//        for (int i = 0; i < repeatDays.length; i++) {
//            repeatDays[i] = true;
//        }
//    }
//
//    public void repeatWeekend() {
//        cancelWeekDays();
//        for (int i = 5; i < repeatDays.length; i++) {
//            repeatDays[i] = true;
//        }
//    }
//
//    public void repeatWeekDays() {
//        for (int i = 0; i < 5; i++) {
//            repeatDays[i] = true;
//        }
//        cancelWeekend();
//    }
}
