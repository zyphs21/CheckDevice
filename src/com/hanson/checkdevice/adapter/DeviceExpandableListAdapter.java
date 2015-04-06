package com.hanson.checkdevice.adapter;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.hanson.checkdevice.model.ChildData;
import com.hanson.checkdevice.model.GroupData;
import com.hanson.checkdevice.R;

public class DeviceExpandableListAdapter extends BaseExpandableListAdapter
{

	private Context mContext;
	private ArrayList<GroupData> mGroupData;
	private ArrayList<List<ChildData>> mChildData;
	private LayoutInflater mInflater;
	
	public DeviceExpandableListAdapter(Context context, ArrayList<GroupData> groupDataList, ArrayList<List<ChildData>> childDataList){
		this.mContext = context;
		this.mGroupData = groupDataList;
		this.mChildData = childDataList;
		mInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	}
	
	@Override
	public View getGroupView(int groupPosition, boolean isExpanded,View convertView, ViewGroup parent) {
		GroupHolder groupHolder;
		if(convertView == null){
			groupHolder = new GroupHolder();
			convertView = mInflater.inflate(R.layout.device_group_layout, parent,false);
			groupHolder.imageView = (ImageView)convertView.findViewById(R.id.group_image);
			groupHolder.textView = (TextView)convertView.findViewById(R.id.group_name);
			convertView.setTag(groupHolder);
		}else{
			groupHolder = (GroupHolder) convertView.getTag();
		}
		groupHolder.imageView.setImageResource( ((GroupData)getGroup(groupPosition)).getImageRes());
		groupHolder.textView.setText(((GroupData) getGroup(groupPosition)).getTitle());
		
		return convertView;
	}

	@Override
	public View getChildView(int groupPosition, int childPosition,boolean isLastChild, View convertView, ViewGroup parent) {
		ChildHolder childHolder;
		if(convertView == null){
			childHolder = new ChildHolder();
			convertView = mInflater.inflate(R.layout.device_child_layout,parent, false);
			childHolder.imageView = (ImageView)convertView.findViewById(R.id.child_image);
			childHolder.textName = (TextView)convertView.findViewById(R.id.child_name);
			convertView.setTag(childHolder);
		}else{
			childHolder = (ChildHolder) convertView.getTag();
		}
		childHolder.imageView.setImageResource( ((ChildData) getChild(groupPosition,childPosition)).getImageRes());
		childHolder.textName.setText(((ChildData) getChild(groupPosition,childPosition)).getName());
		return convertView;
	}
	
	@Override
	public int getGroupCount() {
		return mGroupData.size();
	}

	@Override
	public int getChildrenCount(int groupPosition) {
		return mChildData.get(groupPosition).size();
	}

	@Override
	public Object getGroup(int groupPosition) {
		return mGroupData.get(groupPosition);
	}

	@Override
	public Object getChild(int groupPosition, int childPosition) {
		return mChildData.get(groupPosition).get(childPosition);
	}

	@Override
	public long getGroupId(int groupPosition) {
		return groupPosition;
	}

	@Override
	public long getChildId(int groupPosition, int childPosition) {
		return childPosition;
	}

	@Override
	public boolean hasStableIds() {
		return true;
	}

	@Override
	public boolean isChildSelectable(int groupPosition, int childPosition) {
		return true;
	}
	
	class GroupHolder {
        TextView textView;
        ImageView imageView;
        ImageView expendView;
    }

    class ChildHolder {
        TextView textName;
        ImageView imageView;
    }

}
