package luyunfeng.strawberryclock.alarm_manager.view;

import android.content.Context;
import android.view.Gravity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.PopupWindow;
import android.widget.TextView;


public class SelectRemindCyclePopup implements OnClickListener {
    private TextView tv_mon, tv_tue, tv_wed, tv_thu, tv_fri, tv_sat, tv_sun, tv_sure, every_day,
            tv_drugcycle_once;
    public PopupWindow mPopupWindow;
    private SelectRemindCyclePopupOnClickListener selectRemindCyclePopupListener;

    public PopupWindow getmPopupWindow() {
        return mPopupWindow;
    }

    private Context mContext;

    @SuppressWarnings("deprecation")
    public SelectRemindCyclePopup(Context context) {


    }

    @Override
    public void onClick(View v) {
//        switch (v.getId()) {
//            case R.id.tv_drugcycle_once:
//                selectRemindCyclePopupListener.obtainMessage(9, "");
//                break;
//            case R.id.tv_drugcycle_0:
//                selectRemindCyclePopupListener.obtainMessage(8, "");
//                break;
//            case R.id.tv_drugcycle_1:
//                if (tv_mon.getCompoundDrawables()[2] == null)
//                    tv_mon.setCompoundDrawables(null, null, nav_right, null);
//                else tv_mon.setCompoundDrawables(null, null, null, null);
//                selectRemindCyclePopupListener.obtainMessage(0, "");
//                break;
//            case R.id.tv_drugcycle_2:
//                if (tv_tue.getCompoundDrawables()[2] == null)
//                    tv_tue.setCompoundDrawables(null, null, nav_right, null);
//                else tv_tue.setCompoundDrawables(null, null, null, null);
//                selectRemindCyclePopupListener.obtainMessage(1, "");
//                break;
//            case R.id.tv_drugcycle_3:
//                if (tv_wed.getCompoundDrawables()[2] == null)
//                    tv_wed.setCompoundDrawables(null, null, nav_right, null);
//                else tv_wed.setCompoundDrawables(null, null, null, null);
//                selectRemindCyclePopupListener.obtainMessage(2, "");
//                break;
//            case R.id.tv_drugcycle_4:
//                if (tv_thu.getCompoundDrawables()[2] == null)
//                    tv_thu.setCompoundDrawables(null, null, nav_right, null);
//                else tv_thu.setCompoundDrawables(null, null, null, null);
//                selectRemindCyclePopupListener.obtainMessage(3, "");
//                break;
//            case R.id.tv_drugcycle_5:
//                if (tv_fri.getCompoundDrawables()[2] == null)
//                    tv_fri.setCompoundDrawables(null, null, nav_right, null);
//                else tv_fri.setCompoundDrawables(null, null, null, null);
//                selectRemindCyclePopupListener.obtainMessage(4, "");
//                break;
//            case R.id.tv_drugcycle_6:
//                if (tv_sat.getCompoundDrawables()[2] == null)
//                    tv_sat.setCompoundDrawables(null, null, nav_right, null);
//                else tv_sat.setCompoundDrawables(null, null, null, null);
//                selectRemindCyclePopupListener.obtainMessage(5, "");
//                break;
//            case R.id.tv_drugcycle_7:
//                if (tv_sun.getCompoundDrawables()[2] == null)
//                    tv_sun.setCompoundDrawables(null, null, nav_right, null);
//                else tv_sun.setCompoundDrawables(null, null, null, null);
//                selectRemindCyclePopupListener.obtainMessage(6, "");
//                break;
//            case R.id.tv_drugcycle_sure:
//                int remind = ((tv_mon.getCompoundDrawables()[2] == null) ? 0 : 1) * 1 // 周一
//                        + ((tv_tue.getCompoundDrawables()[2] == null) ? 0 : 1) * 2 // 周二
//                        + ((tv_wed.getCompoundDrawables()[2] == null) ? 0 : 1) * 4 // 周三
//                        + ((tv_thu.getCompoundDrawables()[2] == null) ? 0 : 1) * 8 // 周四
//                        + ((tv_fri.getCompoundDrawables()[2] == null) ? 0 : 1) * 16 // 周五
//                        + ((tv_sat.getCompoundDrawables()[2] == null) ? 0 : 1) * 32 // 周六
//                        + ((tv_sun.getCompoundDrawables()[2] == null) ? 0 : 1) * 64; // 周日
//                selectRemindCyclePopupListener.obtainMessage(7, String.valueOf(remind));
//                dismiss();
//                break;
//            default:
//                break;
//        }

    }

    public interface SelectRemindCyclePopupOnClickListener {
        void obtainMessage(int flag, String ret);
    }

    public void setOnSelectRemindCyclePopupListener(SelectRemindCyclePopupOnClickListener l) {
        this.selectRemindCyclePopupListener = l;
    }

    public void dismiss() {
        if (mPopupWindow != null && mPopupWindow.isShowing()) {
            mPopupWindow.dismiss();
        }
    }

    public void showPopup(View rootView) {
        // 第一个参数是要将PopupWindow放到的View，第二个参数是位置，第三第四是偏移值
        mPopupWindow.showAtLocation(rootView, Gravity.BOTTOM, 0, 0);
    }
}
