package com.hanson.checkdevice.fragment;

import com.hanson.checkdevice.R;

public class DashFragment extends BaseFragment{

	@Override
	protected int getLayoutResourceId() {
		return R.layout.fragment_dash_layout;
	}

	@Override
	protected void onCheckDeviceInitView() {
		
	}

	@Override
	public String getTransactionTag() {
		return "dash_fragment";
	}

}
