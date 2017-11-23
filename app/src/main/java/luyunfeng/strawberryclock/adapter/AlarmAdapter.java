package luyunfeng.strawberryclock.adapter;

import android.view.View;

import java.util.List;

import luyunfeng.strawberryclock.Alarm;
import luyunfeng.strawberryclock.R;

public class AlarmAdapter extends BaseAdapter<Alarm> {

    public AlarmAdapter(List<Alarm> list) {
        super(list);
    }

    @Override
    protected void convert(BaseViewHolder holder, Alarm entity) {
        holder
                .setText(R.id.tv_time, entity.hour + entity.minute)
                .setText(R.id.tv_note, entity.note)
                .setText(R.id.tv_mode, entity.mode)
                .setOnClickListener(R.id.fl_mode, new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                    }
                });
    }
}
