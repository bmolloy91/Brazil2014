package com.brazil2014;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class KOFixtures extends Activity implements View.OnClickListener{
	
	Button GSswitch;
	
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
        setContentView(R.layout.ko_fixtures);
        
        GSswitch = (Button)findViewById(R.id.GS);
        GSswitch.setOnClickListener(this);
	}
    
	public void onClick (View view)
	{
		finish();
		Intent intent = new Intent (this, Fixtures.class);
		startActivity(intent);
		
	}

}
