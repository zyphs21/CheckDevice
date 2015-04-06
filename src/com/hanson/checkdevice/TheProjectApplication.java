package com.hanson.checkdevice;

import android.app.Application;

import com.hanson.checkdevice.TheProjectApplication;

public class TheProjectApplication extends Application{
	
	private int displayWidth,displayHeight;
	private static TheProjectApplication instance;
	
	/**
	 * 单例模式
	 * @return
	 */
	public static TheProjectApplication getInstance(){
		return instance;
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
