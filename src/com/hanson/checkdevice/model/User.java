package com.hanson.checkdevice.model;

import cn.bmob.v3.BmobUser;

public class User extends BmobUser {

	private static final long serialVersionUID = 1L;
	private String gender;
	private String belong;
	
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getBelong() {
		return belong;
	}
	public void setBelong(String belong) {
		this.belong = belong;
	}
	
	
}
