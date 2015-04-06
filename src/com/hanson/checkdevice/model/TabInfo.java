package com.hanson.checkdevice.model;

import android.os.Bundle;
import android.support.v4.app.Fragment;

public class TabInfo {

	private final String tag;
	private final Class<?> clss;
	private final Bundle args;
	private Fragment fragment;

	public TabInfo(String _tag, Class<?> _class, Bundle _args) {
		tag = _tag;
		clss = _class;
		args = _args;
	}

	public Fragment getFragment() {
		return fragment;
	}

	public void setFragment(Fragment fragment) {
		this.fragment = fragment;
	}

	public String getTag() {
		return tag;
	}

	public Class<?> getClss() {
		return clss;
	}

	public Bundle getArgs() {
		return args;
	}
}
