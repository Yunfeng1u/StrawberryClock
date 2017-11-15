package luyunfeng.strawberryclock

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.MotionEvent
import android.view.View
import com.wannar.base_library.resource.ResourceHelper
import com.wannar.wannar_adroid2.util.kotlin_extentions.touchEventHandler
import luyunfeng.strawberryclock.utils.StatusBarUtil

abstract class BaseActivity : AppCompatActivity(), View.OnClickListener {

    var lastValidDownTime = System.currentTimeMillis()
    var lastValidUpTime = System.currentTimeMillis()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(getLayoutId())

        StatusBarUtil.setColorNoTranslucent(this, ResourceHelper.getColor(R.color.dark_bg))

        setUpViews()

        init()
    }

    override fun onClick(v: View) {

    }

    override fun dispatchTouchEvent(ev: MotionEvent) =
            this.touchEventHandler(ev) ?: super.dispatchTouchEvent(ev)

    abstract fun getLayoutId(): Int

    abstract fun init()

    open fun setUpViews(){

    }
}
