package com.lyh.suoping;

import java.io.InputStream;

import android.app.Activity;
import android.app.KeyguardManager;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.Display;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

public class LockView extends Activity implements OnClickListener{

	public int sreenw, sreenh;
	public static final int FLAG_HOMEKEY_DISPATCHED = 0x80000000;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.getWindow().setFlags(FLAG_HOMEKEY_DISPATCHED, FLAG_HOMEKEY_DISPATCHED);//关键代码
		setContentView(R.layout.activity_lock);
		Button button = (Button) findViewById(R.id.button_sure);
		button.setOnClickListener(this);
	}

	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		if (arg0.getId() == R.id.button_sure) {
			KeyguardManager.KeyguardLock kk;
        	KeyguardManager km = (KeyguardManager) LockView.this.getSystemService(KEYGUARD_SERVICE);
        	kk = km.newKeyguardLock("");
        	kk.reenableKeyguard();
			this.finish();
		}
	}

	// 封锁Home键
	@Override
	public void onAttachedToWindow() {
		// TODO Auto-generated method stub
//		this.getWindow().setType(WindowManager.LayoutParams.TYPE_KEYGUARD);
//		super.onAttachedToWindow();
	}

	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		// TODO Auto-generated method stub
		 if (keyCode == event.KEYCODE_HOME) {
             return true;
      }
		return false;
	}
}