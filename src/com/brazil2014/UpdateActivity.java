package com.brazil2014;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class UpdateActivity extends Activity{
	
	TextView name, country;
	Spinner countrySpinner;
	Button update, delete;
	String nameStr, countryStr, winStr;
	UserDetailsDB myDB;
	int id;
	AutoCompleteTextView textView;
	Cursor Cursor1, Cursor2, Cursor3;
	
	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.prediction_update);
        String passedvalue = getIntent().getStringExtra(MainActivity.ID_EXTRA);
        id = Integer.parseInt(passedvalue);
        
        myDB = new UserDetailsDB(this);
		myDB.open();
		name=(TextView)findViewById(R.id.Names);
        country=(TextView)findViewById(R.id.Country);
        countrySpinner=(Spinner)findViewById(R.id.update_spinner);
        
        textView = (AutoCompleteTextView) findViewById(R.id.Country);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line, PickWinner.countries);
        textView.setThreshold(2);
        textView.setAdapter(adapter);
        
        
        countrySpinner = (Spinner)findViewById(R.id.country_spinner);
        ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, Teams.teams);
        adapter2.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        countrySpinner.setAdapter(adapter2);
        
		Cursor1 = myDB.getName(id);
		if(Cursor1.moveToFirst())
		{
			String s1 = Cursor1.getString(0);
			name.setText(s1);
		}
		
		Cursor2 = myDB.getCountry(id);
		if(Cursor2.moveToFirst())
		{
			String s1 = Cursor2.getString(0);
			country.setText(s1);
		}
		
		Cursor3 = myDB.getWinner(id);
		if(Cursor3.moveToFirst())
		{
			countrySpinner.setSelection(0);
		}
		
        
        update=(Button)findViewById(R.id.updateBtn);
        update.setOnClickListener(new OnClickListener()
        {
        	public void onClick (View view) {
        		
        		nameStr=name.getText().toString();
        		countryStr=country.getText().toString();
        		String selectedCountry = countrySpinner.getSelectedItem().toString();
        		winStr=selectedCountry;
        		
        		if(nameStr.equals("") || countryStr.equals(""))
        		{
        			Context context = getApplicationContext();
        			String message = "Please complete all fields";
        			Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
        			
        		}
        		else
        		{
        			myDB.updatePerson(id, nameStr, countryStr, winStr);
            		String message = "Thank you, " + nameStr + ". Your choice was updated";
            		Toast.makeText(UpdateActivity.this, message, Toast.LENGTH_SHORT).show();
            		Intent intent = new Intent(UpdateActivity.this, Predictions.class);
            		
            		startActivity(intent);
            		finish();
        		}
        		
        	}
        });
        delete=(Button)findViewById(R.id.deleteBtn);
        delete.setOnClickListener(new OnClickListener()
        {
        	public void onClick (View view) {
        		nameStr=name.getText().toString();
        		countryStr=country.getText().toString();
        		String selectedCountry = countrySpinner.getSelectedItem().toString();
        		winStr=selectedCountry;
        		myDB.deletePerson(id);
        		String message = "Details Deleted";
        		Toast.makeText(UpdateActivity.this, message, Toast.LENGTH_SHORT).show();
        		Intent intent = new Intent(UpdateActivity.this, Predictions.class);
        		
        		startActivity(intent);
        		finish();
        		
        	}

        });
        myDB.close();
	}

	
}
