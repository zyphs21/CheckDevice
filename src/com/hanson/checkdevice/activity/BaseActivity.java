package com.hanson.checkdevice.activity;

import com.hanson.checkdevice.fragment.BaseFragment;

import android.app.ActionBar;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.view.Menu;
import android.view.MenuItem;

public abstract class BaseActivity extends FragmentActivity
{
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		
		super.onCreate(savedInstanceState);
		
        ActionBar actionBar = getActionBar();
//      actionBar.setDisplayHomeAsUpEnabled(true);
	    actionBar.setHomeButtonEnabled(true);
	    
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
	
//    public void navigateToActivity(Intent intent) {
//    	startActivity(intent);
//    }
	
	@Override 
    public boolean onCreateOptionsMenu(Menu menu) {
    	return super.onCreateOptionsMenu(menu);
    }
    
    @Override
    public boolean onOptionsItemSelected(MenuItem menuItem) {
		switch(menuItem.getItemId()) {
//    	case android.R.id.home:
//    		onBackPressed();
//     		return true;
     	default:
     		break;
    	}
    	return super.onOptionsItemSelected(menuItem);
    }
	
}
