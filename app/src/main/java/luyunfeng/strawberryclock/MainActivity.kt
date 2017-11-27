package luyunfeng.strawberryclock

import com.wannar.wannar_adroid2.util.kotlin_extentions.init
import com.wannar.wannar_adroid2.util.kotlin_extentions.openActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity() {

    override fun init() {

        val list = ArrayList<Alarm>().apply {
            add(Alarm().apply {
                id = 1
                hour = 18
                minute = 30
                note = "测试1"
                repeatDays = kotlin.BooleanArray(7).apply {
                    set(0, true)
                    set(1, true)
                    set(2, true)
                    set(3, true)
                    set(4, true)
                    set(5, false)
                    set(6, false)
                }
            })
            add(Alarm().apply {
                id = 2
                hour = 6
                minute = 30
                note = "测试2"
                repeatDays = kotlin.BooleanArray(7).apply {
                    set(0, true)
                    set(1, true)
                    set(2, true)
                    set(3, true)
                    set(4, true)
                    set(5, true)
                    set(6, true)
                }
            })
            add(Alarm().apply {
                id = 3
                hour = 12
                minute = 45
                note = "测试3"
                repeatDays = kotlin.BooleanArray(7).apply {
                    set(0, true)
                    set(1, false)
                    set(2, false)
                    set(3, true)
                    set(4, true)
                    set(5, true)
                    set(6, true)
                }
            })
        }
        rv_alarms.init()
        //rv_alarms.adapter = AlarmAdapter(list)
    }

    override fun setUpViews() {
        super.setUpViews()
        fab.setOnClickListener {
            openActivity(AlarmSettingActivity::class.java)
        }
    }

    override fun getLayoutId() = R.layout.activity_main
}
