package com.hanson.checkdevice.fragment;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

import com.hanson.checkdevice.R;
import com.zxing.activity.CaptureActivity;

public class DashFragment extends BaseFragment
{
	private static Button scanQRCodeBtn;
	
	@Override
	protected int getLayoutResourceId() {
		return R.layout.fragment_dash_layout;
	}

	@Override
	protected void onCheckDeviceInitView() {
		scanQRCodeBtn = (Button)findViewById(R.id.btn_scan_code);
		scanQRCodeBtn.setOnClickListener(mOnScanBtnClickListener);
		
	}

	@Override
	public String getTransactionTag() {
		return "dash_fragment";
	}
	
	OnClickListener mOnScanBtnClickListener = new OnClickListener() {
		@Override
		public void onClick(View view) {
			Toast.makeText(getActivity(), "你可以扫描条形码或者二维码", Toast.LENGTH_SHORT).show();
			Intent  startScan = new Intent(getActivity(), CaptureActivity.class);
			startActivity(startScan);
		}
	};

}
