package luyunfeng.strawberryclock.alarm_manager;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import luyunfeng.strawberryclock.AlertActivity;

/**
 * Created by loongggdroid on 2016/3/21.
 */
public class AlarmReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        if (intent.getAction().equals(AlarmManagerUtil.ALARM_ACTION)) {
            int id = intent.getIntExtra("id", 0);
            if (id > 0){
                intent.putExtra("id", id);

                if (!AlarmManagerUtil.isNotRepeat()) {
                    AlarmManagerUtil.setAlarm(context, id, AlarmManagerUtil.getNextTime(), intent);
                }

                String note = intent.getStringExtra("note");
                boolean sound = intent.getBooleanExtra("sound", false);
                boolean vibrate = intent.getBooleanExtra("vibrate", false);

                if (!sound && !vibrate){
                    vibrate = true;
                }

                Intent clockIntent = new Intent(context, AlertActivity.class);
                clockIntent.putExtra("note", note);
                clockIntent.putExtra("sound", sound);
                clockIntent.putExtra("vibrate", vibrate);
                clockIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(clockIntent);
            }
        }
    }
}
