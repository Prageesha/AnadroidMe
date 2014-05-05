package com.example.jks;

import com.example.jks.R;
import com.example.jks.R.layout;
import com.example.jks.R.raw;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.preference.PreferenceManager;

public class Growl extends Activity {
	MediaPlayer ourSong;
	@Override
	protected void onCreate(Bundle LoveExo) {
		// TODO Auto-generated method stub
		super.onCreate(LoveExo);
		setContentView(R.layout.growl);
		ourSong=MediaPlayer.create(Growl.this,R.raw.growl);
		SharedPreferences getPrefs=PreferenceManager.getDefaultSharedPreferences(getBaseContext());
		boolean music=getPrefs.getBoolean("checkbox", true);
		if(music==true)
			ourSong.start();
		
		
		Thread timer=new Thread(){
			public void run(){
				try{
					sleep(100);
				}catch(InterruptedException e){
					e.printStackTrace();
				}finally{
					Intent openStartingPoint=new Intent("com.example.jks.MENU");
					startActivity(openStartingPoint);
					
				}
			}
		};
		timer.start();
	}

	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		ourSong.release();
		finish();
	}

}
