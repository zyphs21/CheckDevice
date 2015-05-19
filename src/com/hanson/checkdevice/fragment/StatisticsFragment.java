package com.hanson.checkdevice.fragment;

import android.view.View;
import android.widget.RelativeLayout;

import com.hanson.checkdevice.R;
import com.hanson.checkdevice.view.BaseChart;
public class StatisticsFragment extends BaseFragment {
	
	private RelativeLayout layout;

	public static StatisticsFragment getStatisticsFragment(){
		StatisticsFragment statisticsFragment = new StatisticsFragment();
		return statisticsFragment;
	}
	
	@Override
	protected int getLayoutResourceId() {
		return R.layout.fragment_statistics;
	}

	@Override
	protected void onCheckDeviceInitView() {
		layout = (RelativeLayout)findViewById(R.id.statistics_layout);
		View baseChart = new BaseChart().execute(getActivity());
		layout.addView(baseChart);

	}

	@Override
	public String getTransactionTag() {
		return "fragment_statistics";
	}

}
