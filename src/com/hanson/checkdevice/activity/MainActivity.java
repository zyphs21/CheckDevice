package com.hanson.checkdevice.activity;

import com.hanson.checkdevice.R;
import com.hanson.checkdevice.fragment.HomeFragment;

import android.app.Dialog;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.FragmentManager;
import android.view.Window;
import android.view.ViewGroup.LayoutParams;

public class MainActivity extends BaseActivity {

	private static final int DELAY_SPLASH = 2000;
//	private Dialog mSplashDialog;
//	private Handler mHandler = new Handler();
	
	@Override
	protected void onCheckDeviceCreate(Bundle savedInstanceState) {
		setContentView(R.layout.activity_main);
		//initSplashDialog();
		checkWhetherSetActionBarArrow();
		navigationToFragment(new HomeFragment());
	}
	
	private void checkWhetherSetActionBarArrow() {
        getSupportFragmentManager().addOnBackStackChangedListener(new FragmentManager.OnBackStackChangedListener() {			
			@Override
			public void onBackStackChanged() {
				getActionBar().setDisplayHomeAsUpEnabled(getSupportFragmentManager().getBackStackEntryCount()>0);
			}
		});
    }
	
	@Override
	protected int getContainerResourceId() {
		return R.id.container_id;
	}
	
	//这种方法没法做到全屏；
//	/**
//	 * 打开app看到的闪屏页面，用于展示logo
//	 */
//	private void initSplashDialog(){
//		mSplashDialog = new Dialog(this, R.style.full_screen_dialog) {
//			@Override
//			protected void onCreate(Bundle savedInstanceState) {
//				super.onCreate(savedInstanceState);
//				requestWindowFeature(Window.FEATURE_NO_TITLE);
//				getWindow().setLayout(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT);
//				setContentView(R.layout.dialog_splash);
//			}
//		};
//		
//		mSplashDialog.show();
//		mHandler.postDelayed(new Runnable() {
//			@Override
//			public void run() {
//				onSplashGone();
//			}
//		}, DELAY_SPLASH);
//		
//    }
//	
//	private void onSplashGone() {
//		mSplashDialog.dismiss();
//		//navigateToTabHostFragment(); OR
//		//navigateToSignUpFragment();
//	}

	
}
