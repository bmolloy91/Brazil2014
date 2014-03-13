package com.brazil2014;



import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity implements View.OnClickListener {

	Button groupBtn;
	Button teamsBtn;
	Button winBtn;
	UserDetailsDB myDB;
	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.menu_activity);
		
		myDB = new UserDetailsDB(this);
		myDB.open();
		
		
		groupBtn=(Button)findViewById(R.id.groupBut);
        groupBtn.setOnClickListener(this);
        teamsBtn=(Button)findViewById(R.id.teamBut);
        teamsBtn.setOnClickListener(this);
        winBtn=(Button)findViewById(R.id.winnerBut);
        winBtn.setOnClickListener(this);
	}
	
	public void onClick (View view) {
		
		switch(view.getId())
		{
		case R.id.groupBut:
			Intent intent = new Intent(this, Groups.class);
	    	startActivity(intent);
	    	break;
	    	
		case R.id.winnerBut:
			Intent intent1 = new Intent(this, PickWinner.class);
	    	startActivity(intent1);
	    	break;
	    	
		case R.id.teamBut:
			Intent intent2 = new Intent(this, Teams.class);
	    	startActivity(intent2);
	    	break;
		}
	    
    	
    	
    }

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
