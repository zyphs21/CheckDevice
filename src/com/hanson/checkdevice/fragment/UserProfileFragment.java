package com.hanson.checkdevice.fragment;

import android.widget.TextView;
import cn.bmob.v3.BmobUser;

import com.hanson.checkdevice.R;
import com.hanson.checkdevice.model.User;

public class UserProfileFragment extends BaseFragment{
	private TextView userName;
	private TextView gender;
	private TextView belong;

	public static UserProfileFragment getUserProfileFragment(){
		UserProfileFragment userProfileFragment = new UserProfileFragment();
		return userProfileFragment;
	}
	
	@Override
	protected int getLayoutResourceId() {
		return R.layout.fragment_user_profile;
	}

	@Override
	protected void onCheckDeviceInitView() {
		userName = (TextView)findViewById(R.id.person_name);
		gender = (TextView)findViewById(R.id.person_gender);
		belong = (TextView)findViewById(R.id.person_belong);
		
		User bmobUser =  BmobUser.getCurrentUser(getActivity(), User.class);
		String bmobUserName = bmobUser.getUsername();
		
		if(bmobUserName.equals("zhang")){
			userName.setText("张远平");
		}else{
			userName.setText(bmobUserName);
		}
		gender.setText(bmobUser.getGender());
		belong.setText(bmobUser.getBelong());
	}

	@Override
	public String getTransactionTag() {
		return "fragment_user_proflie";
	}

}
