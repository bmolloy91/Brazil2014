package com.brazil2014;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class PlayerTabsPagerAdapter extends FragmentPagerAdapter {

	public PlayerTabsPagerAdapter(FragmentManager fm) {
		super(fm);
	}

	@Override
	public Fragment getItem(int index) {

		switch (index) {
		case 0:
			// Neymar fragment activity
			return new NeymarFragment();
		case 1:
			// Hazard fragment activity
			return new HazardFragment();
		case 2:
			// Suarez fragment activity
			return new SuarezFragment();
		case 3:
			// Ronaldo fragment activity
			return new RonaldoFragment();
		case 4:
			// Messi fragment activity
			return new MessiFragment();
		}

		return null;
	}

	@Override
	public int getCount() {
		// get item count - equal to number of tabs
		return 5;
	}

}
