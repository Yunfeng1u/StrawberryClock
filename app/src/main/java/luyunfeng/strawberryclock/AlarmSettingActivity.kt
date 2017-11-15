package luyunfeng.strawberryclock

import android.app.AlertDialog
import android.view.LayoutInflater
import android.view.View
import android.widget.CheckBox
import android.widget.CompoundButton
import android.widget.EditText
import com.wannar.base_library.resource.ResourceHelper
import com.wannar.base_library.text.StringUtils
import com.wannar.base_library.tips.Toast
import com.wannar.wannar_adroid2.util.kotlin_extentions.getString
import com.wannar.wannar_adroid2.util.kotlin_extentions.setClickCallback
import com.wannar.wannar_adroid2.util.kotlin_extentions.text
import com.wdullaer.materialdatetimepicker.time.TimePickerDialog
import kotlinx.android.synthetic.main.activity_alarm_setting.*
import java.util.*


class AlarmSettingActivity : BaseActivity(), TimePickerDialog.OnTimeSetListener {

    val TIME_FORMAT = "%02d:%02d"

    lateinit var alarm: Alarm

    lateinit var weekdays: Array<CheckBox>

    override fun init() {
        val tenMinutesAfter = Calendar.getInstance()
        tenMinutesAfter.add(Calendar.MINUTE, 10)
        alarm = Alarm()
        alarm.hour = tenMinutesAfter.get(Calendar.HOUR_OF_DAY)
        alarm.minute = tenMinutesAfter.get(Calendar.MINUTE)
        alarm.note = ""

        updateTime()
        updateNote()
        updateRepeat()
        updateVibrateSound()
    }

    override fun setUpViews() {
        super.setUpViews()
        setClickCallback(rl_time, rl_note, iv_delete, tv_cancel, tv_confirm)
        cb_everyday.setOnCheckedChangeListener(listener)
        cb_weekday.setOnCheckedChangeListener(listener)
        cb_weekend.setOnCheckedChangeListener(listener)

        cb_vibrate.setOnCheckedChangeListener(listener)
        cb_sound.setOnCheckedChangeListener(listener)

        weekdays = Array(7, { it ->
            val checkBox = findViewById<CheckBox>(ResourceHelper.getId("cb_weekday_" + (it + 1)))
            checkBox.setOnCheckedChangeListener(listener)
            checkBox
        })
    }

    override fun onTimeSet(view: TimePickerDialog?, hourOfDay: Int, minute: Int, second: Int) {
        alarm.hour = hourOfDay
        alarm.minute = minute
        updateTime();
    }

    private fun setAlarm() {

    }

    private fun updateTime() {
        tv_time.text(StringUtils.format(TIME_FORMAT, alarm.hour, alarm.minute))
    }

    private fun updateNote() {
        tv_note_content.text(StringUtils.getString(alarm.note, R.string.empty_note))
    }

    private fun updateRepeat() {
        updateWeekButtons()
        updateRepeatButtons()
    }

    private fun updateVibrateSound() {
        cb_vibrate.isChecked = alarm.vibrate
        cb_sound.isChecked = alarm.sound
    }

    override fun onClick(v: View) {
        when (v.id) {
            R.id.rl_time -> {
                val dpd = TimePickerDialog.newInstance(
                        this@AlarmSettingActivity,
                        alarm.hour,
                        alarm.minute,
                        false
                )
                dpd.version = TimePickerDialog.Version.VERSION_1;
                dpd.show(fragmentManager, "TimePickerDialog")
            }
            R.id.rl_note -> {

                val view = LayoutInflater.from(this).inflate(R.layout.component_input, null)

                AlertDialog.Builder(this)
                        .setTitle("要提醒你嘎哈？")
                        .setView(view)
                        .setPositiveButton("确定", { _, _ ->
                            val input = view.findViewById<EditText>(R.id.et_input).getString()
                            alarm.note = input
                            updateNote()
                        })
                        .setNegativeButton("取消", null)
                        .show()
            }
            R.id.iv_delete -> {
                AlertDialog.Builder(this)
                        .setTitle("提示")
                        .setMessage("确认删除？")
                        .setPositiveButton("确定", { _, _ ->
                            Toast.info("删除")
                        })
                        .setNegativeButton("取消", null)
                        .show()
            }
            R.id.tv_cancel -> {
                finish()
            }
            R.id.tv_confirm -> {
                setAlarm()
            }
            else ->
                super.onClick(v)
        }
    }

    val listener = CompoundButton.OnCheckedChangeListener { button: CompoundButton, isChecked: Boolean ->
        if (!button.isPressed) {
            return@OnCheckedChangeListener
        }
        when (button.id) {
            R.id.cb_everyday -> {
                if (isChecked) {
                    alarm.repeatEveryday()
                    updateRepeatButtons(true, false, false)
                } else {
                    alarm.cancelEveryDay()
                }
                updateWeekButtons()
            }
            R.id.cb_weekday -> {
                if (isChecked) {
                    alarm.repeatWeekDays()
                    updateRepeatButtons(false, true, false)
                } else {
                    alarm.cancelWeekDays()
                }
                updateWeekButtons()
            }
            R.id.cb_weekend -> {
                if (isChecked) {
                    alarm.repeatWeekend()
                    updateRepeatButtons(false, false, true)
                } else {
                    alarm.cancelWeekend()
                }
                updateWeekButtons()
            }
            R.id.cb_vibrate -> {
                alarm.vibrate = isChecked
            }
            R.id.cb_sound -> {
                alarm.sound = isChecked
            }
            else -> {
                val index = findIndex(button.id)
                if (index >= 0) {
                    alarm.repeatDays[index] = isChecked
                    updateRepeatButtons();
                }
            }
        }
    }

    private fun updateRepeatButtons(check1: Boolean, check2: Boolean, check3: Boolean) {
        cb_everyday.isChecked = check1
        cb_weekday.isChecked = check2
        cb_weekend.isChecked = check3
    }

    private fun updateRepeatButtons() {
        if (alarm.repeatDays[0]
                && alarm.repeatDays[1]
                && alarm.repeatDays[2]
                && alarm.repeatDays[3]
                && alarm.repeatDays[4]
                && alarm.repeatDays[5]
                && alarm.repeatDays[6]) {
            updateRepeatButtons(true, false, false)
        } else if (alarm.repeatDays[0]
                && alarm.repeatDays[1]
                && alarm.repeatDays[2]
                && alarm.repeatDays[3]
                && alarm.repeatDays[4]
                && !alarm.repeatDays[5]
                && !alarm.repeatDays[6]) {
            updateRepeatButtons(false, true, false)
        } else if (!alarm.repeatDays[0]
                && !alarm.repeatDays[1]
                && !alarm.repeatDays[2]
                && !alarm.repeatDays[3]
                && !alarm.repeatDays[4]
                && alarm.repeatDays[5]
                && alarm.repeatDays[6]) {
            updateRepeatButtons(false, false, true)
        } else {
            updateRepeatButtons(false, false, false)
        }
    }

    private fun updateWeekButtons() {
        alarm.repeatDays.forEachIndexed { index, isCheck ->
            if (weekdays[index].isChecked != isCheck) {
                weekdays[index].isChecked = isCheck
            }
        }
    }

    private fun findIndex(id: Int): Int {
        for (i in 0 until weekdays.size) {
            if (weekdays[i].id == id) {
                return i
            }
        }
        return -1
    }

    override fun getLayoutId() = R.layout.activity_alarm_setting
}
