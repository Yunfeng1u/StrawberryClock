package luyunfeng.strawberryclock.alarm_manager;

import android.content.DialogInterface;
import android.media.MediaPlayer;
import android.os.Vibrator;
import android.support.v7.app.AlertDialog;

import luyunfeng.strawberryclock.BaseActivity;
import luyunfeng.strawberryclock.R;


public class AlertActivity extends BaseActivity {
    private MediaPlayer mediaPlayer;
    private Vibrator vibrator;

    @Override
    public void init() {
        String message = this.getIntent().getStringExtra("msg");
        int flag = this.getIntent().getIntExtra("flag", 0);
        showDialogInBroadcastReceiver(message, flag);
    }

    private void showDialogInBroadcastReceiver(String message, final int flag) {
//        if (flag == 1 || flag == 2) {
//            mediaPlayer = MediaPlayer.create(this, R.raw.in_call_alarm);
//            mediaPlayer.setLooping(true);
//            mediaPlayer.start();
//        }
//        //数组参数意义：第一个参数为等待指定时间后开始震动，震动时间为第二个参数。后边的参数依次为等待震动和震动的时间
//        //第二个参数为重复次数，-1为不重复，0为一直震动
//        if (flag == 0 || flag == 2) {
//            vibrator = (Vibrator) this.getSystemService(Service.VIBRATOR_SERVICE);
//            vibrator.vibrate(new long[]{100, 10, 100, 600}, 0);
//        }

        final AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("闹钟提醒");
        builder.setMessage(message);
        builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
                finish();
            }
        });
        builder.create().show();
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_alert;
    }
}
