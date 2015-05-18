package com.hanson.checkdevice.fragment;

import android.widget.TextView;

import com.hanson.checkdevice.R;

public class UserProfileFragment extends BaseFragment{
	private TextView userName;
	private TextView gender;
	private TextView belong;

	@Override
	protected int getLayoutResourceId() {
		return R.layout.fragment_user_profile;
	}

	@Override
	protected void onCheckDeviceInitView() {
		userName = (TextView)findViewById(R.id.person_name);
		gender = (TextView)findViewById(R.id.person_gender);
		belong = (TextView)findViewById(R.id.person_belong);
	}

	@Override
	public String getTransactionTag() {
		return "fragment_user_proflie";
	}

}
