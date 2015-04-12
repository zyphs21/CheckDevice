package com.hanson.checkdevice;

import android.app.Application;
import com.activeandroid.ActiveAndroid;
import com.hanson.checkdevice.CheckDeviceApplication;

/**
 * 自定义的项目Application，需要在manifest文件中声明
 * @author hanson
 *
 */
public class CheckDeviceApplication extends Application{
	
	private int displayWidth,displayHeight;
	private static CheckDeviceApplication checkDeviceApplicationinstance;
	
	/**
	 * 单例模式 获得checkDeviceApplication实例
	 * @return
	 */
	public static CheckDeviceApplication getInstance(){
		return checkDeviceApplicationinstance;
	}
	
	
	@Override
	public void onCreate() {
		super.onCreate();
		
		if(checkDeviceApplicationinstance == null){
			checkDeviceApplicationinstance = this;
		}
		
		//初始化ActiveAndroid库
		ActiveAndroid.initialize(this);
	}
	

	@Override
	public void onTerminate() {
		super.onTerminate();
		
		//终结ActiveAndroid库
		ActiveAndroid.dispose();
	}


	public int getDisplayWidth() {
		return displayWidth;
	}

	public void setDisplayWidth(int displayWidth) {
		this.displayWidth = displayWidth;
	}

	public int getDisplayHeight() {
		return displayHeight;
	}

	public void setDisplayHeight(int displayHeight) {
		this.displayHeight = displayHeight;
	}
	
	
}
