package com.example.jks;

import com.example.jks.R;
import com.example.jks.R.id;
import com.example.jks.R.menu;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class Menu extends ListActivity {
  String classes[]={"MainActivity","TextPlay","Email","Camera","Data","Open","Prefs","AboutUS","GFX","GFXSURFECE"};
 // classes[4];
	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		// TODO Auto-generated method stub
		String chees=classes[position];
		super.onListItemClick(l, v, position, id);
		//Class ourClass;
		
			
			try {
				Class ourClass = Class.forName("com.example.jks." +chees);
				Intent ourIntent=new Intent(Menu.this,ourClass);
				startActivity(ourIntent);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		
		
	}
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		//fullscreen
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, 
				WindowManager.LayoutParams.FLAG_FULLSCREEN);
		setListAdapter(new ArrayAdapter<String>(Menu.this,android.R.layout.simple_list_item_1,classes));
	}
	@Override
	public boolean onCreateOptionsMenu(android.view.Menu menu) {
		// TODO Auto-generated method stub
		 super.onCreateOptionsMenu(menu);
		MenuInflater blowUp=getMenuInflater();
		blowUp.inflate(R.menu.cool_menu, menu);
		return true;
	}
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// TODO Auto-generated method stub
		switch(item.getItemId()){
		case R.id.aboutUs:
			Intent i=new Intent("com.example.jks.ABOUT");
			startActivity(i);
			break;
		case R.id.preferences:
			Intent s=new Intent("com.example.jks.PREFS");
			startActivity(s);
			break;
		
	case R.id.exit:
		finish();
		break;
	}
	
		return false;
		
	}
	
	

	
	

}
