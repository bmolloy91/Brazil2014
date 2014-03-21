package com.brazil2014;

import android.app.Activity;
import android.app.ListActivity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v4.widget.SimpleCursorAdapter;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

public class Predictions extends ListActivity implements View.OnClickListener{
	
	Button create;
	Cursor myCursor;
	UserDetailsDB myDB;
	SimpleCursorAdapter myAdapter;
	
	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.prediction_list);
        
        myDB = new UserDetailsDB(this);
		myDB.open();
        
        create =(Button)findViewById(R.id.createBtn);
        create.setOnClickListener(this);
        
        populateListView();
	}

	private void populateListView()
	{
		String[] columns = new String[] {"name"};
		myCursor = myDB.getAllPeople();
		
		int[] to = new int [] {R.id.editName};

		myAdapter = new SimpleCursorAdapter(this, R.layout.people, myCursor, columns, to);
		this.setListAdapter(myAdapter);
		ListView list = (ListView)findViewById(R.id.predictionList);
		
		list.setAdapter(myAdapter);
	}
	
	public void onClick (View view) {
		Intent intent = new Intent(this, PickWinner.class);
		startActivity(intent);
		
	}

}
