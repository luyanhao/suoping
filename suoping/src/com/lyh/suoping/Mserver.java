package com.lyh.suoping;

import android.app.KeyguardManager;
import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.IBinder;

public class Mserver extends Service {

    @Override
    public IBinder onBind(Intent arg0) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void onStart(Intent intent, int startId) {
        // TODO Auto-generated method stub
        
        //注册监听系统锁屏信息
        registerReceiver(br, new IntentFilter(Intent.ACTION_SCREEN_OFF));
        
    }
    
    private BroadcastReceiver br = new BroadcastReceiver() {
        
        @Override
        public void onReceive(Context context, Intent intent) {
            // TODO Auto-generated method stub
            if(intent.getAction().equals(Intent.ACTION_SCREEN_OFF)){
                KeyguardManager.KeyguardLock kk;
                KeyguardManager km = (KeyguardManager) context.getSystemService(KEYGUARD_SERVICE);
                kk = km.newKeyguardLock("");
                kk.disableKeyguard();
                showLockView(context);
            }
            if(intent.getAction().equals(Intent.ACTION_SCREEN_ON)){
            }
            
        }
    };
    
    public void showLockView(Context context){
        Intent intent = new Intent(context,LockView.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent);
    }


}