package luyunfeng.strawberryclock.model

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.wannar.base_library.log.Log
import luyunfeng.strawberryclock.utils.SPUtils
import com.google.gson.reflect.TypeToken
import com.wannar.wannar_adroid2.util.kotlin_extentions.isValid


/**
 * Created by luyunfeng on 2017/11/28.
 */

object AlarmService {

    val list: ArrayList<Alarm> = ArrayList()

    fun loadAlarmList() {
        val json = SPUtils.getAlarms()

        val type = object : TypeToken<ArrayList<Alarm>>() {

        }.type

        val tempList = GsonBuilder().create().fromJson<List<Alarm>>(json, type)

        if (tempList.isValid()) {
            list.addAll(tempList)
        }

//        val list = ArrayList<Alarm>().apply {
//            add(Alarm().apply {
//                id = 1
//                hour = 18
//                minute = 30
//                note = "测试1"
//                repeatDays = kotlin.BooleanArray(7).apply {
//                    set(0, true)
//                    set(1, true)
//                    set(2, true)
//                    set(3, true)
//                    set(4, true)
//                    set(5, false)
//                    set(6, false)
//                }
//            })
//            add(Alarm().apply {
//                id = 2
//                hour = 6
//                minute = 30
//                note = "测试2"
//                repeatDays = kotlin.BooleanArray(7).apply {
//                    set(0, true)
//                    set(1, true)
//                    set(2, true)
//                    set(3, true)
//                    set(4, true)
//                    set(5, true)
//                    set(6, true)
//                }
//            })
//            add(Alarm().apply {
//                id = 3
//                hour = 12
//                minute = 45
//                note = "测试3"
//                repeatDays = kotlin.BooleanArray(7).apply {
//                    set(0, true)
//                    set(1, false)
//                    set(2, false)
//                    set(3, true)
//                    set(4, true)
//                    set(5, true)
//                    set(6, true)
//                }
//            })
//        }
    }

    fun addAlarm(alarm: Alarm) {
        list.add(alarm)
        save()
    }

    fun save() {
        val json = GsonBuilder().create().toJson(list)
        Log.d(json)
        SPUtils.saveAlarms(json)
    }
}
