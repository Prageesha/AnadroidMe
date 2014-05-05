package com.example.jks;

import com.example.jks.R;
import com.example.jks.R.id;
import com.example.jks.R.layout;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Email extends Activity implements View.OnClickListener {

	EditText personsEmail,intro,personsName,stupidThings,hatefulAction,outro;
	String emailAdd,beginning,name,stupidAction,hateulAct,out;
	Button sendEmail;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.email);
		initializeVars();
		sendEmail.setOnClickListener(this);
	}


	private void initializeVars() {
		// TODO Auto-generated method stub
		personsEmail=(EditText)findViewById(R.id.etEmails);
		intro=(EditText)findViewById(R.id.etIntro);
		personsName=(EditText)findViewById(R.id.etName);
		stupidThings=(EditText)findViewById(R.id.etThings);
		hatefulAction=(EditText)findViewById(R.id.etAction);
		outro=(EditText)findViewById(R.id.bSentEmail);
		
	}


	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		convertEditTextVarsIntoStringAndYesThisIsAMethodWeCreated();
		String emailaddress[]={emailAdd};
		String message="Well hello"
				+name
				+"I Just Wanted to say"
				+beginning
				+".Not only that I hate when you"
				+stupidAction
				+",that just really makes me crazy.I Just wantto make"
				+hateulAct
				+".Wel,thats all I wanted to chit-chatter about"
				+out
				+".Oh also if you get bored you should check out"
				+'\n'+"PS.I think I love you......";
				
		Intent emailIntent=new Intent(android.content.Intent.ACTION_SEND);
		emailIntent.putExtra(android.content.Intent.EXTRA_EMAIL,emailaddress);
		emailIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, "I hate you!");
		emailIntent.setType("plain/text");
		emailIntent.putExtra(android.content.Intent.EXTRA_TEXT, message);
		startActivity(emailIntent);
		
	}


	private void convertEditTextVarsIntoStringAndYesThisIsAMethodWeCreated() {
		// TODO Auto-generated method stub
		emailAdd=personsEmail.getText().toString();
		beginning=intro.getText().toString();
		name=personsName.getText().toString();
		stupidAction=stupidThings.getText().toString();
		hateulAct=hatefulAction.getText().toString();
		out=outro.getText().toString();
	}


	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		finish();
	}
	

}
