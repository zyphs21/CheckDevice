package com.hanson.checkdevice.fragment;

import android.support.v4.view.ViewPager;
import com.hanson.checkdevice.R;
import com.hanson.checkdevice.adapter.TabPageIndicatorAdapter;
import com.hanson.checkdevice.model.TabInfo;
import com.hanson.checkdevice.util.NavigationTabManager;
import com.viewpagerindicator.TabPageIndicator;

public class HomeFragment extends BaseFragment{
	
	private static final String DASH_PAGE= "信息";
	private static final String DEVICE_PAGE = "设备";

	@Override
	protected int getLayoutResourceId() {
		return R.layout.fragment_home_layout;
	}

	@Override
	protected void onCheckDeviceInitView() {
		
		TabInfo[] tabs=new TabInfo[]{
				new TabInfo(DASH_PAGE, DashFragment.class, null),
				new TabInfo(DEVICE_PAGE, DeviceFragment.class, null),
		};
		
		NavigationTabManager navigationTabManager=new NavigationTabManager(getCurrentActivity(),tabs);

		TabPageIndicatorAdapter adapter = new TabPageIndicatorAdapter(navigationTabManager); 
        
        ViewPager pager = (ViewPager)findViewById(R.id.pager);  
        pager.setAdapter(adapter);

        TabPageIndicator indicator = (TabPageIndicator)findViewById(R.id.indicator);  
        indicator.setViewPager(pager);  
	}

	@Override
	public String getTransactionTag() {
		return "home_fragment";
	}

}
