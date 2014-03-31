package com.brazil2014;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class PickWinner extends Activity implements View.OnClickListener{
	
	TextView name, country, win;
	Button submit;
	String nameStr, countryStr, winStr;
	UserDetailsDB myDB;
	AutoCompleteTextView textView, textView2;
	
	
	public static String[] countries = {"Afghanistan", "Albania", "Algeria", "Andorra", "Angola", "Argentina", "Armenia", "Aruba", "Australia", "Austria", "Azerbaijan", "Bahamas", "Bahrain", "Bangladesh", "Barbados", "Belarus", "Belgium", "Belize", "Bolivia",
			"Bosnia and Herzegowina", "Botswana", "Brazil", "Brunei Darussalam", "Bulgaria", "Burkina Faso", "Burundi", "Cambodia", "Cameroon", "Canada", "Cayman Islands", "Chad", "Chile", "China", "Colombia", "Congo", "Costa Rica", 
			"Cote d'Ivoire", "Croatia", "Cuba", "Cyprus", "Czech Republic", "Denmark", "Dominican Republic", "Ecuador", "Egypt", "El Salvador", "Estonia", "Ethiopia", "Faroe Islands", "Fiji", "Finland", "France", "Gambia", "Georgia",
			"Germany", "Ghana", "Gibraltar", "Greece", "Greenland", "Guyana", "Haiti", "Honduras", "Hong Kong", "Hungary", "Iceland", "India", "Indonesia", "Iran", "Iraq", "Ireland", "Israel", "Italy", "Jamaica", "Japan", "Jordan", 
			"Kazakhstan", "Kenya", "Korea, Democratic People's Republic of", "Korea, Republic of", "Kuwait", "Kyrgyzstan", "Latvia", "Lebanon", "Liberia", "Liechtenstein", "Lithuania", "Luxembourg", "Macedonia", "Madagascar", "Malawi", 
			"Malaysia", "Maldives", "Mali", "Malta", "Mauritius", "Mayotte", "Mexico", "Moldova", "Monaco", "Mongolia", "Morocco", "Mozambique", "Namibia", "Nepal", "Netherlands", "New Zealand", "Nicaragua", "Niger", "Nigeria", "Northern Ireland", "Norway",
			"Oman", "Pakistan", "Panama", "Papua New Guinea", "Paraguay", "Peru", "Philippines", "Poland", "Portugal", "Puerto Rico", "Qatar",  "Romania", "Russia", "Rwanda", "Samoa", "San Marino", "Saudi Arabia", "Scotland", "Senegal", "Singapore", 
			"Slovakia", "Slovenia", "Somalia", "South Africa", "Spain", "Sri Lanka", "Sudan", "Suriname", "Sweden", "Switzerland", "Syria", "Taiwan", "Tanzania", "Thailand", "Togo", "Tonga", "Trinidad and Tobago", "Tunisia", "Turkey", 
			"Turkmenistan", "Uganda", "Ukraine", "United Arab Emirates", "United States", "Uruguay", "Uzbekistan", "Vanuatu", "Venezuela", "Vietnam", "`Wales", "Yemen", "Zambia", "Zimbabwe"};

	
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
        
        textView = (AutoCompleteTextView) findViewById(R.id.editCountry);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line, countries);
        textView.setThreshold(2);
        textView.setAdapter(adapter);
        
        
        textView2 = (AutoCompleteTextView) findViewById(R.id.editWinner);
        ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line, Teams.teams);
        textView2.setThreshold(1);
        textView2.setAdapter(adapter2);
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
		finish();
	}

}
