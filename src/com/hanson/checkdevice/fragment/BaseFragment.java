package com.hanson.checkdevice.fragment;

import com.hanson.checkdevice.activity.MainActivity;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnTouchListener;
import android.widget.Toast;

public abstract class BaseFragment extends Fragment
{
	View rootView;
	MainActivity mCurrentActivity;
	
	@Override
	public void onAttach(Activity activity) {
		super.onAttach(activity);
		if(activity instanceof MainActivity) {
			mCurrentActivity=(MainActivity)activity;
		}
		onCheckDeviceAttach();
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState){
		
		int layoutResourceId=getLayoutResourceId();
		final Context contextThemeWrapper = new ContextThemeWrapper(getActivity(), com.viewpagerindicator.R.style.Theme_PageIndicatorDefaults);
		if(layoutResourceId!=0){
			LayoutInflater localInflater = inflater.cloneInContext(contextThemeWrapper);
			rootView = localInflater.inflate(layoutResourceId, container, false);
			
			onCheckDeviceInitView();
		}
		return rootView;
		
	}
	
	
	@Override
	public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
		super.onCreateOptionsMenu(menu, inflater);
		for(int i=0;i<menu.size();i++){
    		menu.removeGroup(i);
    	}
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		onCheckDeviceCreate(savedInstanceState);
	}
	
	protected View getCurrentView(){
		return rootView;
	}
	
	protected View findViewById(int resourceId){
		return rootView.findViewById(resourceId);
	}
	
	
	protected MainActivity getCurrentActivity() {
		return mCurrentActivity;
	}
	
	protected void showToast(String msg){
    	Toast.makeText(getActivity(), msg, Toast.LENGTH_SHORT).show();
    }
	
	@Override
	public void onStart() {
		super.onStart();
		onCheckDeviceStart();
	}
	
	@Override
	public void onDestroy() {
		super.onDestroy();
		onCheckDeviceDestroy();
	}

	@Override
	public void onDestroyView() {
		super.onDestroyView();
		onCheckDeviceDestroyView();
	}

	@Override
	public void onPause() {
		super.onPause();
		onCheckDevicePause();
	}

	@Override
	public void onResume() {
		super.onResume();
		onCheckDeviceResume();
	}

	@Override
	public void onStop() {
		super.onStop();
		onCheckDeviceStop();
	}

	abstract protected int getLayoutResourceId();
	
	abstract protected void onCheckDeviceInitView();
	
	abstract public String getTransactionTag();
	
	
	protected void onCheckDeviceAttach() {}
	
	protected void onCheckDeviceCreate(Bundle savedInstanceState) {}
	
	
	protected void onCheckDeviceStart() {}
	
	protected void onCheckDeviceResume() {}
	
	protected void onCheckDevicePause() {}
	
	protected void onCheckDeviceStop() {}
	
	protected void onCheckDeviceDestroy() {}
	
	protected void onCheckDeviceDestroyView() {}

	@Override
	public void onViewCreated(View view, Bundle savedInstanceState) {
		view.setOnTouchListener(new OnTouchListener() {
			
			@Override
			public boolean onTouch(View v, MotionEvent event) {
				return true;
			}
		});
		super.onViewCreated(view, savedInstanceState);
	}
}
