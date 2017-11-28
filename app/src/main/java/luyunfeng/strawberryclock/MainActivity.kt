package luyunfeng.strawberryclock

import com.wannar.wannar_adroid2.util.kotlin_extentions.init
import com.wannar.wannar_adroid2.util.kotlin_extentions.openActivity
import kotlinx.android.synthetic.main.activity_main.*
import luyunfeng.strawberryclock.adapter.AlarmAdapter
import luyunfeng.strawberryclock.model.AlarmService

class MainActivity : BaseActivity() {

    override fun init() {

    }

    override fun onResume() {
        super.onResume()
        AlarmService.loadAlarmList()
        rv_alarms.init()
        rv_alarms.adapter = AlarmAdapter(AlarmService.list)
    }
    override fun setUpViews() {
        super.setUpViews()
        fab.setOnClickListener {
            openActivity(AlarmSettingActivity::class.java)
        }
    }

    override fun getLayoutId() = R.layout.activity_main
}
