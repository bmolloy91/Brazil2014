package com.brazil2014;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class FixtureSelect extends Activity implements View.OnClickListener{
	
	Button groupStg;
	Button KO;
	
	protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fixture_select);
        
        groupStg=(Button)findViewById(R.id.groupStgBut);
        groupStg.setOnClickListener(this);
        KO=(Button)findViewById(R.id.teamBut);
        KO.setOnClickListener(this);
	}
	
	public void onClick (View view)
	{
			
			switch(view.getId())
			{
				case R.id.groupStgBut:
					Intent intent = new Intent(this, Fixtures.class);
			    	startActivity(intent);
			    	break;
			    	
				case R.id.teamBut:
					Intent intent2 = new Intent(this, KOFixtures.class);
			    	startActivity(intent2);
			    	break;
			}
	}

}
