package com.hanson.checkdevice.util;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;

import com.hanson.checkdevice.model.TabInfo;

public class NavigationTabManager {

	private final FragmentActivity mActivity;
	TabInfo[] mTabs;
	
	
	public NavigationTabManager(FragmentActivity activity,TabInfo[] tabs) {
		mActivity = activity; 
		mTabs=tabs;
	}
	
	public FragmentManager getSupportFragmentManager(){
		return mActivity.getSupportFragmentManager();
	}
	
	public int getTabCount(){
		return mTabs.length;
	}
	
	public String getTitleByTabPosition(int position){
		return mTabs[position].getTag();
	}
	
	
	
	public Fragment getFragmentByTabChanged(int position){
		TabInfo tabInfo = mTabs[position];
		Fragment fragment=tabInfo.getFragment();
		//mActivity.getSupportFragmentManager().beginTransaction().hide(arg0)
		if(fragment==null || fragment.isDetached()){
			tabInfo.setFragment(Fragment.instantiate(mActivity,
					tabInfo.getClss().getName(), tabInfo.getArgs()));
		}
		return tabInfo.getFragment();
	}
}
