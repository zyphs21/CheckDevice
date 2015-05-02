package com.hanson.checkdevice.activity;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.Window;

import com.hanson.checkdevice.R;

@SuppressLint("HandlerLeak")
public class SplashActivity extends Activity{

	private static final int TO_HOME_PAGE = 100;
	private Handler mHandler = new Handler() {
		@Override
		public void handleMessage(Message msg) {
			switch (msg.what) {
			case TO_HOME_PAGE:
				toHome();
				break;
			}
		}
	};

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//requestWindowFeatur必须在setContentView之前调用
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_splash);
		mHandler.sendEmptyMessageDelayed(TO_HOME_PAGE, 2000);
	};
	public void toHome() {
		Intent intent = new Intent(this, MainActivity.class);
		startActivity(intent);
		this.finish();
	}

	
}
