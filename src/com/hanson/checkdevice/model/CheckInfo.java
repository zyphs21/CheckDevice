package com.hanson.checkdevice.model;

import cn.bmob.v3.BmobObject;
/**
 * 设备需要点检的信息
 * @author hanson
 *
 */
public class CheckInfo extends BmobObject
{
	//点检内容
	private String content;
	
	//点检的员工
	private String staff;
	
	//点检标准
	private String standard;
	
	//点检属于的设备
	private String device;
	
	//点检结果
	private boolean isGood;
	
	
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
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
	public String getDevice() {
		return device;
	}
	public void setDevice(String device) {
		this.device = device;
	}
	public boolean isGood() {
		return isGood;
	}
	public void setGood(boolean isGood) {
		this.isGood = isGood;
	}
	
	
}
