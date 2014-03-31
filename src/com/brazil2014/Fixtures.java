package com.brazil2014;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

	public class Fixtures extends Activity implements View.OnClickListener
	{
		Button KOswitch;
	
		protected void onCreate(Bundle savedInstanceState)
		{
			super.onCreate(savedInstanceState);
	        setContentView(R.layout.group_fixtures);
	        
	        KOswitch = (Button)findViewById(R.id.KOS);
	        KOswitch.setOnClickListener(this);
		}
        
		public void onClick (View view)
		{
			finish();
			Intent intent = new Intent (this, KOFixtures.class);
			startActivity(intent);
			
		}
        
    }

