package com.brazil2014;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.Window;
import android.widget.ImageView;

public class SplashScreen extends Activity {
	//Reference: The following code is from Android example @http://www.itcuties.com/android/how-to-create-android-splash-screen/
	private static String TAG = SplashScreen.class.getName();
	private static long SLEEP_TIME = 2000;
	//reference complete
	AnimationDrawable logoAnimation;
	@Override
	
	protected void onCreate(Bundle savedInstanceState)
	{
		
		
		super.onCreate(savedInstanceState);
		
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
			
		setContentView(R.layout.activity_splash);
		
		ImageView logo = (ImageView) findViewById(R.id.opening);
		logo.setBackgroundResource(R.drawable.start_logo);
		logoAnimation = (AnimationDrawable) logo.getBackground();
		logoAnimation.start();
		
		// Start timer and launch main activity
	      IntentLauncher launcher = new IntentLauncher();
	      launcher.start();

	}
	
	//Reference: The following code is from Android example @http://www.itcuties.com/android/how-to-create-android-splash-screen/
	private class IntentLauncher extends Thread 
	{
		@Override
		public void run()
		{
			try
			{
				Thread.sleep(SLEEP_TIME);
			} 
			catch (Exception e)
			{
				Log.e(TAG, e.getMessage());
			}
			
			Intent intent = new Intent(SplashScreen.this, MainActivity.class);
			SplashScreen.this.startActivity(intent);
			SplashScreen.this.finish();
			//reference complete
		}
	}
}

