package com.brazil2014;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class StadiumTabsPagerAdapter extends  FragmentPagerAdapter{
	public StadiumTabsPagerAdapter(FragmentManager fm) {
		super(fm);
	}
	
	@Override
	public Fragment getItem(int index) {

		switch (index) 
		{
			case 0:
				return new BeloFragment();
			case 1:
				// Hazard fragment activity
				return new BrasiliaFragment();
			case 2:
				// Suarez fragment activity
				return new CuiabaFragment();
			case 3:
				// Ronaldo fragment activity
				return new CuritibaFragment();
			case 4:
				// Messi fragment activity
				return new FortalezaFragment();
			case 5:
				// Ronaldo fragment activity
				return new ManausFragment();
			case 6:
				// Messi fragment activity
				return new NatalFragment();
			case 7:
				// Ronaldo fragment activity
				return new PortoFragment();
			case 8:
				// Messi fragment activity
				return new RecifeFragment();
			case 9:
				// Ronaldo fragment activity
				return new RioFragment();
			case 10:
				// Messi fragment activity
				return new SalvadorFragment();
			case 11:
				// Ronaldo fragment activity
				return new SaoFragment();
				
		
		}
		return null;
	}
	
	@Override
	public int getCount() 
	{
		// get item count - equal to number of tabs
		return 12;
	}

}
