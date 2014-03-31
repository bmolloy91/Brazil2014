package com.brazil2014;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

	public class Teams extends Activity
	{
		//create list
		public static String[] teams = {"Brazil", "Algeria", "Argentina", "Australia","Belgium",
				"Bosnia and Herzegovina","Cameroon", "Chile", "Colombia", "Costa Rica",
				"Croatia", "Ecuador", "England", "France", "Germany", "Ghana", "Greece", "Honduras"
				, "Iran", "Italy", "Japan", "Korea Republic", "Mexico", "Netherlands", "Nigeria",
				"Portugal", "Russia", "Spain", "Switzerland", "Uruguay", "USA"};
	
		protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.team_activity);
        
        populateListView();
        registerClickCallBack();
        
    }
		
		private void populateListView()
		{
			
			
			//build adapter
			ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.teams, teams);
			
			//configure list view
			ListView list = (ListView) findViewById(R.id.teamList);
			list.setAdapter(adapter);
			
		}
		
		private void registerClickCallBack()
		{
			ListView list = (ListView) findViewById(R.id.teamList);
			list.setOnItemClickListener(new AdapterView.OnItemClickListener()
			{

				@Override
				public void onItemClick(AdapterView<?> parent, View viewClicked, int position,long id)
				{
					TextView textview = (TextView) viewClicked;
					String message = "You chose " + textview.getText().toString();
					Toast.makeText(Teams.this, message, Toast.LENGTH_SHORT).show();
					
				}
				
				
			});
		}
	}
