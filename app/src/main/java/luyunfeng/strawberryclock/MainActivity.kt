package luyunfeng.strawberryclock

import com.wannar.wannar_adroid2.util.kotlin_extentions.openActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity() {

    override fun init() {

        rv_alarms.adapter

    }

    override fun setUpViews() {
        super.setUpViews()
        fab.setOnClickListener {
            openActivity(AlarmSettingActivity::class.java)
        }
    }

    override fun getLayoutId() = R.layout.activity_main
}
