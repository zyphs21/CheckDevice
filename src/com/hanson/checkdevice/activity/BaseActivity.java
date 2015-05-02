package com.hanson.checkdevice.activity;

import cn.bmob.v3.Bmob;

import com.hanson.checkdevice.fragment.BaseFragment;

import android.app.ActionBar;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.view.Menu;
import android.view.MenuItem;
/**
 * Activity 的基本抽象类
 * @author hanson
 *
 */
public abstract class BaseActivity extends FragmentActivity
{
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
        ActionBar actionBar = getActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
	    actionBar.setHomeButtonEnabled(true);
	    
	    //初始化云端数据库bmob
        Bmob.initialize(this, "85de52c741b61dc4822090fa9ceb5963");
	    
	    onCheckDeviceCreate(savedInstanceState);
	}

	abstract protected void onCheckDeviceCreate(Bundle savedInstanceState);
	
	public void navigationToFragment(BaseFragment baseFragment){
		
		FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
		ft.replace(getContainerResourceId(), baseFragment, baseFragment.getTransactionTag());
		ft.commitAllowingStateLoss();
		getSupportFragmentManager().executePendingTransactions();
	}
	
	public void addFragment(BaseFragment baseFragment){
		
		FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
		
		ft.add(getContainerResourceId(), baseFragment, baseFragment.getTransactionTag());
		ft.addToBackStack(baseFragment.getTransactionTag());
		ft.commitAllowingStateLoss();
		getSupportFragmentManager().executePendingTransactions();
		
	}
		
	protected int getContainerResourceId() {
		return -1;
	}
	
    public void navigateToActivity(Intent intent) {
    	startActivity(intent);
    }
	
	@Override 
    public boolean onCreateOptionsMenu(Menu menu) {
    	return super.onCreateOptionsMenu(menu);
    }
    
    @Override
    public boolean onOptionsItemSelected(MenuItem menuItem) {
		switch(menuItem.getItemId()) {
    	case android.R.id.home:
    		onBackPressed();
     		return true;
     	default:
     		break;
    	}
    	return super.onOptionsItemSelected(menuItem);
    }
	
}
