package com.hanson.checkdevice.model;

import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;

/**
 * 设备表
 * @author hanson
 *
 */

@Table(name="Device")
public class Device extends DeviceBaseModel{

	@Column(name="Category")
	Category category;
	
	@Column(name="DeviceName")
	String deviceName;
	
	@Column(name="Info")
	String info;
	
	@Column(name="Staff")
	String staff;
	
	@Column(name="Standard")
	String standard;
	
	@Column(name="IsGood")
	boolean isGood;

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public String getDeviceName() {
		return deviceName;
	}

	public void setDeviceName(String deviceName) {
		this.deviceName = deviceName;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	public String getStaff() {
		return staff;
	}

	public void setStaff(String staff) {
		this.staff = staff;
	}

	public String getStandard() {
		return standard;
	}

	public void setStandard(String standard) {
		this.standard = standard;
	}

	public boolean isGood() {
		return isGood;
	}

	public void setGood(boolean isGood) {
		this.isGood = isGood;
	}
}
