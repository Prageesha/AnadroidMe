package com.example.jks;
import java.io.IOException;

import com.example.jks.R;
import com.example.jks.R.id;
import com.example.jks.R.layout;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;


public class Camera extends Activity implements View.OnClickListener{
	
	ImageButton ib;
	Button b;
	ImageView iv;
	Intent i;
	final static int cameraData=0;
	Bitmap bit;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.photo);
		intialize();
	}
	private void intialize() {
		// TODO Auto-generated method stub
		iv=(ImageView)findViewById(R.id.ivReturnedPic);
		ib=(ImageButton)findViewById(R.id.ibTakePic);
		b=(Button)findViewById(R.id.bSetWall);
		b.setOnClickListener(this);
		ib.setOnClickListener(this);
		
	}
	@SuppressWarnings("deprecation")
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch(v.getId()){
		case R.id.bSetWall:
			try {
				getApplicationContext().setWallpaper(bit);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		case R.id.ibTakePic:
			i=new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
			startActivityForResult(i,cameraData);
			break;
		}
		
	}
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		// TODO Auto-generated method stub
		super.onActivityResult(requestCode, resultCode, data);
	if(resultCode==RESULT_OK){
		Bundle extras=data.getExtras();
		bit=(Bitmap)extras.get("data");
		iv.setImageBitmap(bit);
	}
	}
	
	
	
	

}
