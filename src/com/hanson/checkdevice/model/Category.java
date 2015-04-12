package com.hanson.checkdevice.model;

import java.util.List;

import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;

/**
 * 设备所属的生产线类目表
 * @author hanson
 *
 */

@Table(name="Category")
public class Category extends DeviceBaseModel{

	
	@Column(name="CategoryId")
	String categoryId;
	
	@Column(name="CategoryName")
	String categoryName;
	
	public List<Device> device(){
		return getMany(Device.class,"Categroy");
	}
	
	public String getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

}
