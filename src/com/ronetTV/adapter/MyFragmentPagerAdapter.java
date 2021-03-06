package com.ronetTV.adapter;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.ronetTV.iptv.CategoryFragment;
import com.ronetTV.iptv.VodActivity;

public class MyFragmentPagerAdapter extends FragmentPagerAdapter {

	SharedPreferences mPrefs;

	public MyFragmentPagerAdapter(FragmentManager fragmentManager) {
		super(fragmentManager);
	}

	@Override
	public int getCount() {
		return VodActivity.ITEMS;
	}

	@Override
	public Fragment getItem(int position) {
		Bundle b = new Bundle();
		b.putInt("pageno", position);
		Fragment fragment = new CategoryFragment();
		fragment.setArguments(b);
		return fragment;
	}
}
