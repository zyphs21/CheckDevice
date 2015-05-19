package com.hanson.checkdevice.fragment;
import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import com.hanson.checkdevice.R;

public class ContactFragment extends BaseFragment {

	private Button btn1;
	private Button btn2;
	private Button btn3;
	
	public static ContactFragment getContactFragment(){
		ContactFragment contactFragment = new ContactFragment();
		return contactFragment;
	}
	
	@Override
	protected int getLayoutResourceId() {
		return R.layout.fragment_contact;
	}

	@Override
	protected void onCheckDeviceInitView() {
		btn1 = (Button)findViewById(R.id.button1);
		btn2 = (Button)findViewById(R.id.button2);
		btn3= (Button)findViewById(R.id.button3);
		
		btn1.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				callMethod();
			}
		});
		btn2.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				callMethod();
			}
		});
		btn3.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				callMethod();
			}
		});
	}
	
	private void callMethod(){
		Intent intent = new Intent();
		intent.setAction("android.intent.action.CALL");
		intent.setData(Uri.parse("tel:"+ "13824453727"));
		startActivity(intent);
	}

	@Override
	public String getTransactionTag() {
		return "fragment_contact";
	}

}
