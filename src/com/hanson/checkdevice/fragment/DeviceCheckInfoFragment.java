package com.hanson.checkdevice.fragment;

import java.util.List;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.listener.FindListener;
import cn.bmob.v3.listener.UpdateListener;

import com.hanson.checkdevice.R;
import com.hanson.checkdevice.fragment.InfoListAdapter.ItemHolder;
import com.hanson.checkdevice.model.CheckInfo;

/**
 * 点检表具体页面
 * @author hanson
 *
 */
public class DeviceCheckInfoFragment extends BaseFragment{

	private static final String DEVICE_NAME = "device_name";
	private static final String DEVICE = "device";
	
	private String mDeviceName;
	private ListView lvInfo;
	private TextView tvDeviceName;
	private ProgressBar pbLoading;
	private Button comfirm;
	private InfoListAdapter infoListAdapter;	
	/**
	 * 静态方法，用于外部跳转到该fragment时 传递值
	 * @param deviceName
	 * @return DeviceCheckInfoFragment
	 */
	public static DeviceCheckInfoFragment getDeviceCheckInfoFragment(String deviceName)
	{
		DeviceCheckInfoFragment deviceCheckInfoFragment = new DeviceCheckInfoFragment();
		
		Bundle arguments = new Bundle();
		arguments.putString(DEVICE_NAME, deviceName);
		
		deviceCheckInfoFragment.setArguments(arguments);
		
		return deviceCheckInfoFragment;
	}
	
	@Override
	protected int getLayoutResourceId() {
		return R.layout.fragment_device_check_info_layout;
	}

	@Override
	protected void onCheckDeviceInitView() {
		
		Bundle bundle = getArguments();
		mDeviceName = bundle.getString(DEVICE_NAME);
		
		tvDeviceName = (TextView) findViewById(R.id.tv_device);
		lvInfo = (ListView) findViewById(R.id.lv_info);
		pbLoading = (ProgressBar) findViewById(R.id.loading_bar);
		comfirm = (Button) findViewById(R.id.btn_check);		
		
		comfirm.setOnClickListener(mOnComfirmClickListener);
		tvDeviceName.setText(mDeviceName);
		lvInfo.setVisibility(View.GONE);
		pbLoading.setVisibility(View.VISIBLE);
		
		//根据传过来的DeviceName 从bmob云端数据库查找对应的点检信息
		BmobQuery<CheckInfo> query = new BmobQuery<CheckInfo>();
		query.addWhereEqualTo(DEVICE, mDeviceName);
		query.findObjects(getCurrentActivity(), new FindListener<CheckInfo>() {
			
			@Override
			public void onSuccess(List<CheckInfo> info) {
				
				infoListAdapter = new InfoListAdapter(getActivity(), info);
				lvInfo.setAdapter(infoListAdapter);
				lvInfo.setOnItemClickListener(mOnInfoClickListener);
				
				lvInfo.setVisibility(View.VISIBLE);
				pbLoading.setVisibility(View.GONE);
			}
			
			@Override
			public void onError(int arg0, String arg1) {
				System.out.println("erro in here"+" "+arg1 +arg0);
			}

		});
	}

	/**
	 * listview的点击事件
	 */
	ListView.OnItemClickListener mOnInfoClickListener = new ListView.OnItemClickListener(){
		@Override
		public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
			ItemHolder holder = (ItemHolder)view.getTag();
			CheckBox checkBox = holder.checkBox;
			checkBox.toggle();
			boolean isGood=checkBox.isChecked();
			((CheckInfo)lvInfo.getItemAtPosition(position)).setGood(isGood);
		}
	};
	
	OnClickListener mOnComfirmClickListener = new OnClickListener(){
		@Override
		public void onClick(View v) {
			int count = lvInfo.getCount();
			for(int i=0; i<count; i++){
				CheckInfo checkInfo = (CheckInfo) lvInfo.getItemAtPosition(i);
				String objectId = checkInfo.getObjectId();
				
				checkInfo.update(getActivity(), objectId, new UpdateListener() {
					@Override
					public void onSuccess() {
						showToast("上传成功");
					}
					@Override
					public void onFailure(int arg0, String arg1) {
						showToast("上传失败");
					}
				});
			}
		}
	};
	
	@Override
	public String getTransactionTag() {
		return "deviceCheckInfo_fragment";
	}

}
