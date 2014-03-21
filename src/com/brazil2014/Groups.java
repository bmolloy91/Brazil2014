package com.brazil2014;

import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class Groups extends Activity {
	

	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.groups_activity);
        
        populateListView();
        registerClickCallBack();
        
    }

	

	private void populateListView()
	{
		//create list
		String[] groups = {"Group A", "Group B", "Group C", "Group D","Group E",
				"Group F","Group G", "Group H"};
		
		//build adapter
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.groups, groups);
		
		//configure list view
		ListView list = (ListView) findViewById(R.id.groupList);
		list.setAdapter(adapter);
		
	}
	
	private void registerClickCallBack()
	{
		ListView list = (ListView) findViewById(R.id.groupList);
		list.setOnItemClickListener(new AdapterView.OnItemClickListener()
		{

			@Override
			public void onItemClick(AdapterView<?> parent, View viewClicked, int position,long id)
			{
				TextView textview = (TextView) viewClicked;
				String message = "You chose " + textview.getText().toString();
				Toast.makeText(Groups.this, message, Toast.LENGTH_SHORT).show();
				
			}
			
			
		});
			
	}
    
}
