package com.hanson.checkdevice.fragment;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;

import com.hanson.checkdevice.R;
import com.hanson.checkdevice.model.CheckInfo;

public class InfoListAdapter extends BaseAdapter
{
	private Context mContext;
	private List<CheckInfo> mList;
	private LayoutInflater mLayoutInflater;
	
	public InfoListAdapter(Context context,List<CheckInfo> list){
		this.mContext = context;
		this.mList = new ArrayList<CheckInfo>(list);
		
		mLayoutInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	}
	
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		
		ItemHolder holderView;
	
		if(convertView==null){
			holderView=new ItemHolder();
			convertView = mLayoutInflater.inflate(R.layout.fragment_device_check_info_list_item_layout,parent, false);
			holderView.checkBox=(CheckBox)convertView.findViewById(R.id.checkBox);
			convertView.setTag(holderView);
		}else{
			holderView=(ItemHolder) convertView.getTag();
		}
		
		holderView.checkBox.setText(((CheckInfo)mList.get(position)).getContent());
		holderView.checkBox.setChecked(((CheckInfo)mList.get(position)).isGood());
	
		return convertView;
	}
	
	@Override
	public int getCount() {
		return mList.size();
	}

	@Override
	public Object getItem(int position) {
		return mList.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}
	
	public class ItemHolder{
		 public CheckBox checkBox;
	}

}
