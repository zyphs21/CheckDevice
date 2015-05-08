package com.hanson.checkdevice.fragment;

import java.util.ArrayList;
import java.util.List;

import android.view.View;
import android.widget.ExpandableListView;

import com.diegocarloslima.fgelv.lib.FloatingGroupExpandableListView;
import com.diegocarloslima.fgelv.lib.WrapperExpandableListAdapter;
import com.hanson.checkdevice.R;
import com.hanson.checkdevice.adapter.DeviceExpandableListAdapter;
import com.hanson.checkdevice.model.ChildData;
import com.hanson.checkdevice.model.GroupData;

/**
 * 点检设备列表，用expandableListView
 * @author hanson
 * 
 */
public class DeviceFragment extends BaseFragment{
	
	private FloatingGroupExpandableListView exListView;
	private DeviceExpandableListAdapter mExListAdapter;
	private WrapperExpandableListAdapter mWrapperAdapter;
	private ArrayList<GroupData> mGroupDataList;
	private ArrayList<List<ChildData>> mChildDataList;
	private final int mGroupImage[] = new int[3];
	private final int mChildImage[] = new int[6];
	private final String[] mGroups = {"总装","热交换","配管"};
	private final String[][] mChilds = {
			{"抽真空线","打包机","升降吊笼","吸夹机","折弯机","注氟机"},
			{"脱脂烘干机","自动焊接机"},
			{"CNC弯管机","辅助管道自动焊接机","管端成型机","毛细管开料机","配管烘干炉","直管开料机"},
	};

	@Override
	protected int getLayoutResourceId() {
		return R.layout.fragment_device_layout;
	}

	@Override
	protected void onCheckDeviceInitView() {
		
		exListView = (FloatingGroupExpandableListView)findViewById(R.id.expandablelist);
		
		getData();
		
		mExListAdapter = new  DeviceExpandableListAdapter(this.getActivity(), mGroupDataList, mChildDataList);
		mWrapperAdapter = new WrapperExpandableListAdapter(mExListAdapter);
		exListView.setAdapter(mWrapperAdapter);
		
		//默认显示都是展开的expandableListview
		int count = exListView.getCount();
		for(int i = 0; i < count; i++){
			exListView.expandGroup(i);
		}
		
		exListView.setOnChildClickListener(mOnChildClickListener);
		
		//将expandableListview箭头移动到右边的方法，但是失效了
//		int width = this.getActivity().getWindowManager().getDefaultDisplay().getWidth();
//      exListView.setIndicatorBounds(width-40, width);
//      exListView.setIndicatorBounds(exListView.getRight()- 40, exListView.getWidth());
        exListView.setGroupIndicator(null);
	}

	@Override
	public String getTransactionTag() {
		return "device_fragment";
	}
	
	/**
	 * 初始化列表的数据，
	 */
	public void getData(){
		GroupData groupData;
		ChildData childData;
		mChildDataList = new ArrayList<List<ChildData>>();
		mGroupDataList = new ArrayList<GroupData>();
		
		for(int i = 0; i < mGroups.length; i++){
			mGroupImage[i] = (int) R.drawable.empty_photo;
			groupData = new GroupData();
			groupData.setImageRes(mGroupImage[i]);
			groupData.setTitle(mGroups[i]);
			mGroupDataList.add(groupData);
		}
		
		for(int i = 0; i < mGroupDataList.size(); i++){
			List<ChildData> childDataTemp = new ArrayList<ChildData>();
			for(int j = 0; j < mChilds[i].length; j++){
				mChildImage[j] = (int) R.drawable.empty_photo;
				childData = new ChildData();
				childData.setImageRes(mChildImage[j]);
				childData.setName(mChilds[i][j]);
				childDataTemp.add(childData);
			}
			mChildDataList.add(childDataTemp);
		}
	}
	
	/**
	 * 子项点击事件，进入到对应设备的点检表
	 */
	FloatingGroupExpandableListView.OnChildClickListener mOnChildClickListener = 
			new FloatingGroupExpandableListView.OnChildClickListener(){
		@Override
		public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {
			
			getCurrentActivity().addFragment(DeviceCheckInfoFragment.getDeviceCheckInfoFragment( mChilds[groupPosition][childPosition] ));
			return false; 
		}
	};


}
