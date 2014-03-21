package com.brazil2014;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class PickWinner extends Activity implements View.OnClickListener{
	
	EditText name, country, win;
	Button submit;
	String nameStr, countryStr, winStr;
	UserDetailsDB myDB;
	
	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.winner_activity);
        
        myDB = new UserDetailsDB(this);
		myDB.open();
        
        name=(EditText)findViewById(R.id.editName);
        country=(EditText)findViewById(R.id.editCountry);
        win=(EditText)findViewById(R.id.editWinner);
        submit=(Button)findViewById(R.id.submitBtn);
        submit.setOnClickListener(this);
	}
	
	public void onClick (View view) {
		nameStr=name.getText().toString();
		countryStr=country.getText().toString();
		winStr=win.getText().toString();
		myDB.insertDetails(nameStr, countryStr, winStr);
		String message = "Thank you, " + nameStr + ". Your choice was recorded";
		Toast.makeText(PickWinner.this, message, Toast.LENGTH_SHORT).show();
		Intent intent = new Intent(this, Predictions.class);
		startActivity(intent);
	}

}
