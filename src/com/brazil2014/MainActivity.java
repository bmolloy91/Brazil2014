package com.brazil2014;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity implements View.OnClickListener {
	
	public final static String ID_EXTRA = "com.brazil2014._ID";

	Button groupBtn;
	Button fxtBtn;
	Button stadiumBtn;
	Button starsBtn;
	Button winBtn;
	
	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.menu_activity);
		
		groupBtn=(Button)findViewById(R.id.groupBut);
        groupBtn.setOnClickListener(this);
        fxtBtn=(Button)findViewById(R.id.fxtBut);
        fxtBtn.setOnClickListener(this);
        stadiumBtn=(Button)findViewById(R.id.stadiumBut);
        stadiumBtn.setOnClickListener(this);
        starsBtn=(Button)findViewById(R.id.starsBut);
        starsBtn.setOnClickListener(this);
        winBtn=(Button)findViewById(R.id.winnerBut);
        winBtn.setOnClickListener(this);
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
		
	}
	
	public void onClick (View view) {
		
		switch(view.getId())
		{
		case R.id.groupBut:
			Intent intent = new Intent(this, Groups.class);
	    	startActivity(intent);
	    	break;
	    	
		case R.id.fxtBut:
			Intent intent2 = new Intent(this, FixtureSelect.class);
	    	startActivity(intent2);
	    	break;
	    	 	
		case R.id.stadiumBut:
			Intent intent3 = new Intent(this, Stadiums.class);
	    	startActivity(intent3);
	    	break;
	    	
		case R.id.starsBut:
			Intent intent4 = new Intent(this, Stars.class);
			startActivity(intent4);
			break;
	    	
		case R.id.winnerBut:
			Intent intent1 = new Intent(this, Predictions.class);
	    	startActivity(intent1);
	    	break;
		}
	    
    	
    	
    }
}
