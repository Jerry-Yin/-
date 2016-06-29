package com.greentech.ansibledt.diaospad.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.TableRow;

import com.greentech.ansibledt.diaospad.constant.Config;
import com.greentech.ansibledt.diaospad.service.LongTimeService;
import com.greentech.ansibledt.diaospad.utils.SharedPreferencesUtil;

/**
 * Created by JerryYin on 6/29/16.
 */
public class AlarmReceiver extends BroadcastReceiver {


    private static final String TAG = "AlarmReceiver";

    @Override
    public void onReceive(Context context, Intent intent) {
//        boolean isDone = intent.getBooleanExtra("isDone", false);
        boolean isDone = SharedPreferencesUtil.getSharedSettingMode(context, Config.IS_DONE, false);

        Intent intent1 = new Intent(context, LongTimeService.class);
        Log.d(TAG, " isDone = " + isDone);
        Log.d(TAG, " this = " + this);
        if (!isDone) {
            context.startService(intent1);
            Log.d(TAG, "startService()");
            SharedPreferencesUtil.setSharedSettingMode(context, Config.IS_DONE, true);
            // TODO: 6/29/16 提醒用户或者说修改用户状态至可抢状态  通过Spref数据库来判别是否可以抢
            SharedPreferencesUtil.setSharedSettingMode(context, Config.GRAB_ENABLE, true);

        }else {
            context.stopService(intent1);
            Log.d(TAG, "stopService()");
        }
    }
}
