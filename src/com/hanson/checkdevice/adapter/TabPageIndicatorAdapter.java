package com.hanson.checkdevice.adapter;

import com.hanson.checkdevice.util.NavigationTabManager;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class TabPageIndicatorAdapter extends FragmentPagerAdapter{

	NavigationTabManager mNavigationTabManager;
	
	public TabPageIndicatorAdapter(FragmentManager fm) {
		super(fm);
	}
	
	public TabPageIndicatorAdapter(NavigationTabManager navigationTabManager) {
		this(navigationTabManager.getSupportFragmentManager());
		mNavigationTabManager=navigationTabManager;
	}

	@Override
	public Fragment getItem(int position) {
		return mNavigationTabManager.getFragmentByTabChanged(position);
	}

	@Override
	public int getCount() {
		return mNavigationTabManager.getTabCount(); 
	}
	
	@Override
	public CharSequence getPageTitle(int position) {		
		return mNavigationTabManager.getTitleByTabPosition(position);
	}

}
