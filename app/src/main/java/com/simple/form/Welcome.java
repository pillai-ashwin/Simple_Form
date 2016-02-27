package com.simple.form;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class Welcome extends Activity{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.welcome);
		Intent i = getIntent();
		Bundle extras = i.getExtras();
		
		String name = extras.getString("name");
		String msg = "Welcome " + name;
		TextView TextView_msg = (TextView) findViewById(R.id.textView_msg);
		
		TextView_msg.setText(msg);
	}

}
