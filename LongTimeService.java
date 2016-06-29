package com.greentech.ansibledt.diaospad.service;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.SystemClock;
import android.support.annotation.Nullable;
import android.util.Log;
import android.widget.Toast;

import com.greentech.ansibledt.diaospad.receiver.AlarmReceiver;
import com.greentech.ansibledt.diaospad.utils.SharedPreferencesUtil;
import com.greentech.ansibledt.diaospad.utils.ToastUtils;

/** 
 * Created by JerryYin on 6/29/16.
 * 后台长时间的定时服务
 * 实现方式： 发送广播，在广播中再次启动服务，形成一个死循环
 * <p/>
 * 需求：只需要执行一次，设定标志位，
 */
public class LongTimeService extends Service {
    public static final String TAG = "LongTimeService";

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }


    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        AlarmManager manager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
        long time = SystemClock.elapsedRealtime() + 10 * 60 * 1000;  // 定时 10 min
        Intent i = new Intent(getApplicationContext(), AlarmReceiver.class);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(getApplicationContext(), 0, i, 0);
        manager.set(AlarmManager.ELAPSED_REALTIME_WAKEUP, time, pendingIntent);

        return super.onStartCommand(intent, flags, startId);
    }


    @Override
    public void onDestroy() {
        super.onDestroy();
    }


//    class TaskThread extends Thread{
//      public  boolean isDone = false;
//
//        @Override
//        public void run() {
//            super.run();
//            if (!isDone){
//                Log.d(TAG, "run() is running" + System.currentTimeMillis());
//                Log.d(TAG, " isDone = " + isDone);
//            }
//        }
//
//        public void stopThread(){
//            this.isDone = true;
//        }
//    }
}
