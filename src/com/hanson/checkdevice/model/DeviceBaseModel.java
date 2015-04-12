package com.hanson.checkdevice.model;

import org.json.JSONException;
import org.json.JSONObject;

import android.text.TextUtils;

import com.activeandroid.Model;
/**
 * 继承于ActiveAndroid的Model类
 * 为所有设备表Model 提供基本方法
 * @author hanson
 *
 */
public class DeviceBaseModel extends Model{

	public DeviceBaseModel(){
		super();
	}
	
	/**
	 * 用于接收json对象来给model类的属性赋值
	 * @param json
	 * @throws JSONException
	 */
	public DeviceBaseModel(JSONObject json) throws JSONException {
		super();
		parseJson(json);
	}
	
	protected void  parseJson(JSONObject json) throws JSONException{
	}
	
	protected boolean isEmpty(String value) {
		return TextUtils.isEmpty(value) || "null".equalsIgnoreCase(value);
	}
	
}
