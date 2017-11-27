package luyunfeng.strawberryclock.adapter;

import android.view.View;

import com.wannar.base_library.text.StringUtils;

import java.util.List;

import luyunfeng.strawberryclock.Alarm;
import luyunfeng.strawberryclock.R;
import luyunfeng.strawberryclock.alarm_manager.AlarmManagerUtil;
import luyunfeng.strawberryclock.global.Constant;

public class AlarmAdapter extends BaseAdapter<Alarm> {

    public AlarmAdapter(List<Alarm> list) {
        super(R.layout.list_alarm, list);
    }

    @Override
    protected void convert(BaseViewHolder holder, Alarm entity) {
        holder
                .setText(R.id.tv_time, StringUtils.format(Constant.TIME_FORMAT, entity.hour, entity.minute))
                .setText(R.id.tv_note, entity.note)
                .setText(R.id.tv_mode, String.valueOf(entity.mode))
                .setOnClickListener(R.id.fl_mode, new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                    }
                });


        if (AlarmManagerUtil.isEveryDay(entity.repeatDays)) {
            holder.setNotNullText(R.id.tv_repeat_mode, "每天");
        } else if (AlarmManagerUtil.isWeekday(entity.repeatDays)) {
            holder.setNotNullText(R.id.tv_repeat_mode, "平日");
        } else if (AlarmManagerUtil.isWeekend(entity.repeatDays)) {
            holder.setNotNullText(R.id.tv_repeat_mode, "周末");
        } else {
            holder.setNotNullText(R.id.tv_repeat_mode, null);
        }
    }
}
