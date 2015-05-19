package com.hanson.checkdevice.fragment;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import cn.bmob.v3.BmobUser;

import com.hanson.checkdevice.R;
import com.hanson.checkdevice.activity.LoginActivity;
import com.zxing.activity.CaptureActivity;

public class DashFragment extends BaseFragment
{
	private Button scanQRCodeBtn;
	private Button contactBtn;
	private Button dataBtn;
	private Button newsBtn;
	private TextView switchAccount;
	private TextView userProfile;
	private TextView userName;
	
	@Override
	protected int getLayoutResourceId() {
		return R.layout.fragment_dash_layout;
	}

	@Override
	protected void onCheckDeviceInitView() {
		
		scanQRCodeBtn = (Button)findViewById(R.id.btn_scan_code);
		contactBtn = (Button)findViewById(R.id.btn_contact);
		dataBtn = (Button)findViewById(R.id.btn_data);
		newsBtn = (Button)findViewById(R.id.btn_news);
		
		switchAccount = (TextView)findViewById(R.id.tv_account);
		userProfile = (TextView)findViewById(R.id.tv_profile);
		userName = (TextView)findViewById(R.id.tv_name);
		
		
		BmobUser bmobUser = BmobUser.getCurrentUser(getActivity());
		String bmobUserName = bmobUser.getUsername();
		if(bmobUserName.equals("zhang")){
			userName.setText("张远平");
		}else{
			userName.setText(bmobUserName);
		}
		
		scanQRCodeBtn.setOnClickListener(mOnScanBtnClickListener);
		switchAccount.setOnClickListener(mOnSwitchAccountClickListener);
		userProfile.setOnClickListener(mOnUserProfileClickListener);
		contactBtn.setOnClickListener(mOnContactClickListener);
		dataBtn.setOnClickListener(mOnDateClickListener);
		newsBtn.setOnClickListener(mOnNewsClickListener);
	}

	@Override
	public String getTransactionTag() {
		return "dash_fragment";
	}
	
	OnClickListener mOnScanBtnClickListener = new OnClickListener() {
		@Override
		public void onClick(View view) {
			Toast.makeText(getActivity(), "你可以扫描条形码或者二维码", Toast.LENGTH_SHORT).show();
			Intent  startScan = new Intent(getActivity(), CaptureActivity.class);
			startActivity(startScan);
		}
	};
	
	OnClickListener mOnSwitchAccountClickListener = new OnClickListener(){
		@Override
		public void onClick(View view) {
			BmobUser.logOut(getActivity());
			Intent goToLogIn = new Intent(getActivity(), LoginActivity.class);
			startActivity(goToLogIn);
			getActivity().finish();
		}
	};
	
	OnClickListener mOnUserProfileClickListener = new OnClickListener(){
		@Override
		public void onClick(View view) {
			getCurrentActivity().addFragment(UserProfileFragment.getUserProfileFragment());
		}
	};
	
	OnClickListener mOnContactClickListener = new OnClickListener() {
		@Override
		public void onClick(View v) {
			getCurrentActivity().addFragment(ContactFragment.getContactFragment());
		}
	};
	
	OnClickListener mOnDateClickListener = new OnClickListener() {
		@Override
		public void onClick(View v) {
			getCurrentActivity().addFragment(StatisticsFragment.getStatisticsFragment());
		}
	};

	OnClickListener mOnNewsClickListener = new OnClickListener() {
		@Override
		public void onClick(View v) {
			getCurrentActivity().addFragment(NewsFragment.getNewsFragment());
		}
	};
}
