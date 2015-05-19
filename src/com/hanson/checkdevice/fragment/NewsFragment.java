package com.hanson.checkdevice.fragment;

import com.hanson.checkdevice.R;

public class NewsFragment extends BaseFragment {

	public static NewsFragment getNewsFragment(){
		NewsFragment newsFragment = new NewsFragment();
		return newsFragment;
	}
	
	@Override
	protected int getLayoutResourceId() {
		return R.layout.fragment_news;
	}

	@Override
	protected void onCheckDeviceInitView() {
		
	}

	@Override
	public String getTransactionTag() {
		return "fragment_news";
	}

}
